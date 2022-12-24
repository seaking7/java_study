# FeignClient

### 사전준비 openfeign 추가
```groovy
ext {
	/**
	 * Spring Boot and springCloudVersion must be compatible.
	 * 2.6.x, 2.7.x (Starting with 2021.0.3) = 2021.0.x
	 * ref : https://spring.io/projects/spring-cloud
	 */
	// Feign
	set('springCloudVersion', '2021.0.3')
}

dependencyManagement {
	imports {
		mavenBom "org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"
	}
}

dependencies {
	implementation 'org.springframework.cloud:spring-cloud-starter-openfeign'
}
```

###  @EnableFeignClients 추가, [별도 Configuration 에서 추가도 가능(basePackageClasses 정의)](https://huisam.tistory.com/entry/feigntest?category=759193)
```java
@EnableFeignClients
@SpringBootApplication
public class FeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignApplication.class, args);
	}

}
```

### FeignClient interface
```java

@FeignClient(
        name = "demo-client", // application.yaml에 설정해 놓은 값을 참조
        url = "${feign.url.prefix}", // application.yaml에 설정해 놓은 값을 참조 (= http://localhost:8080/target_server)
        configuration = DemoFeignConfig.class)
public interface DemoFeignClient {

    @GetMapping("/get") // "${feign.url.prefix}/get"으로 요청
    ResponseEntity<BaseResponseInfo> callGet(@RequestHeader(CUSTOM_HEADER_NAME) String customHeader,
                                             @RequestParam("name") String name,
                                             @RequestParam("age") Long age);

    @PostMapping("/post") // "${feign.url.prefix}/post"로 요청
    ResponseEntity<BaseResponseInfo> callPost(@RequestHeader(CUSTOM_HEADER_NAME) String customHeader,
                                              @RequestBody BaseRequestInfo baseRequestInfo);

    @GetMapping("/errorDecoder")
    ResponseEntity<BaseResponseInfo> callErrorDecoder();
}
```

### 호출부
```java
@Service
@RequiredArgsConstructor
public class DemoService {

	private final DemoFeignClient client;

	public String get() {
		ResponseEntity<BaseResponseInfo> response = client.callGet("CustomHeader",
			"CustomName",
			1L);
		System.out.println("Name : " + response.getBody().getName());
		System.out.println("Age : " + response.getBody().getAge());
		System.out.println("Header : " + response.getBody().getHeader());
		return "get";
	}
	
	public String post() {
		BaseRequestInfo requestBody = BaseRequestInfo.builder()
			.name("customName")
			.age(1L)
			.build();
		ResponseEntity<BaseResponseInfo> response = client.callPost("CustomHeader",
			requestBody);
		System.out.println("Name : " + response.getBody().getName());
		System.out.println("Age : " + response.getBody().getAge());
		System.out.println("Header : " + response.getBody().getHeader());
		return "post";
	}

}
```

### interceptor 설정으로 호출전 동작 추가
```java
@RequiredArgsConstructor(staticName = "of")
public final class DemoFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) { // 필요에 따라 template 필드 값을 활용하자!

        // get 요청일 경우
        if (template.method() == HttpMethod.GET.name()) {
            System.out.println("[GET] [DemoFeignInterceptor] queries : " + template.queries());
            // ex) [GET] [DemoFeignInterceptor] queries : {name=[CustomName], age=[1]}
            return;
        }

        // post 요청일 경우
        String encodedRequestBody = StringUtils.toEncodedString(template.body(), UTF_8);
        System.out.println("[POST] [DemoFeignInterceptor] requestBody : " + encodedRequestBody);
        // ex) [POST] [DemoFeignInterceptor] requestBody : {"name":"customName","age":1}

        // Do Something
        // ex) requestBody 값 수정 등등

        // 새로운 requestBody 값으로 설정
        template.body(encodedRequestBody);
    }
}
```

### interceptor Bean 등록
```java
@Configuration
public class DemoFeignConfig {

    @Bean
    public DemoFeignInterceptor feignInterceptor() {
        return DemoFeignInterceptor.of();
    }
}
```

### 로깅처리 logAndRebufferResponse 에서 로깅 커스터마이징
```java
@Slf4j
@RequiredArgsConstructor
public class FeignCustomLogger extends Logger {
    private static final int DEFAULT_SLOW_API_TIME = 3_000;
    private static final String SLOW_API_NOTICE = "Slow API";

    @Override
    protected void log(String configKey, String format, Object... args) {
        // log를 어떤 형식으로 남길지 정해준다.
        // System.out.println(String.format(methodTag(configKey) + format, args));
        log.info(String.format(methodTag(configKey) + format, args));
    }

    @Override
    protected void logRequest(String configKey, Logger.Level logLevel, Request request) {
        /**
         * [값]
         * configKey = DemoFeignClient#callGet(String,String,Long)
         * logLevel = BASIC # "feign.client.config.demo-client.loggerLevel" 참고
         *
         * [동작 순서]
         * `logRequest` 메소드 진입 -> 외부 요청 -> `logAndRebufferResponse` 메소드 진입
         *
         * [참고]
         * request에 대한 정보는
         * `logAndRebufferResponse` 메소드 파라미터인 response에도 있다.
         * 그러므로 request에 대한 정보를 [logRequest, logAndRebufferResponse] 중 어디에서 남길지 정하면 된다.
         * 만약 `logAndRebufferResponse`에서 남긴다면 `logRequest`는 삭제해버리자.
         */
        // System.out.println(request);
        log.info(request.toString());
    }

    @Override
    protected Response logAndRebufferResponse(String configKey, Logger.Level logLevel,
                                              Response response, long elapsedTime) throws IOException {
        /**
         * [참고]
         * - `logAndRebufferResponse` 메소드내에선 Request, Response에 대한 정보를 log로 남길 수 있다.
         * - 매소드내 코드는 "feign.Logger#logAndRebufferResponse(java.lang.String, feign.Logger.Level, feign.Response, long)"에서 가져왔다.
         *
         * [사용 예]
         * 예상 요청 처리 시간보다 오래 걸렸다면 "Slow API"라는 log를 출력시킬 수 있다.
         * ex) [DemoFeignClient#callGet] <--- HTTP/1.1 200 (115ms)
         *     [DemoFeignClient#callGet] connection: keep-alive
         *     [DemoFeignClient#callGet] content-type: application/json
         *     [DemoFeignClient#callGet] date: Sun, 24 Jul 2022 01:26:05 GMT
         *     [DemoFeignClient#callGet] keep-alive: timeout=60
         *     [DemoFeignClient#callGet] transfer-encoding: chunked
         *     [DemoFeignClient#callGet] {"name":"customName","age":1,"header":"CustomHeader"}
         *     [DemoFeignClient#callGet] [Slow API] elapsedTime : 3001
         *     [DemoFeignClient#callGet] <--- END HTTP (53-byte body)
         */

        String protocolVersion = resolveProtocolVersion(response.protocolVersion());
        String reason = response.reason() != null
                        && logLevel.compareTo(Level.NONE) > 0 ? " " + response.reason() : "";
        int status = response.status();
        log(configKey, "<--- %s %s%s (%sms)", protocolVersion, status, reason, elapsedTime);
        StringBuilder headerLog = new StringBuilder();
        if (logLevel.ordinal() >= Level.HEADERS.ordinal()) {

            for (String field : response.headers().keySet()) {
                if (shouldLogResponseHeader(field)) {
                    for (String value : valuesOrEmpty(response.headers(), field)) {
                        // log(configKey, "%s: %s", field, value);
                        headerLog.append(value).append("/");
                    }
                }
            }

            log(configKey, "header: %s", headerLog.toString());
            // log(configKey, "response: %s", response.toString());

            int bodyLength = 0;
            if (response.body() != null && !(status == 204 || status == 205)) {
                // HTTP 204 No Content "...response MUST NOT include a message-body"
                // HTTP 205 Reset Content "...response MUST NOT include an entity"
                if (logLevel.ordinal() >= Level.FULL.ordinal()) {
                    log(configKey, ""); // CRLF
                }
                byte[] bodyData = Util.toByteArray(response.body().asInputStream());
                bodyLength = bodyData.length;
                if (logLevel.ordinal() >= Level.HEADERS.ordinal() && bodyLength > 0) {
                    log(configKey, "%s", decodeOrDefault(bodyData, UTF_8, "Binary data"));
                }
                if (elapsedTime > DEFAULT_SLOW_API_TIME) {
                    log(configKey, "[%s] elapsedTime : %s", SLOW_API_NOTICE, elapsedTime);
                }
                log(configKey, "<--- END HTTP (%s-byte body)", bodyLength);
                return response.toBuilder().body(bodyData).build();
            } else {
                log(configKey, "<--- END HTTP (%s-byte body)", bodyLength);
            }
        }
        return response;
    }
}
```

### 호출 이후 Error 처리. 별도 CustomException 으로 변환 필요
```java

public final class DemoFeignErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        final HttpStatus httpStatus = HttpStatus.resolve(response.status());

        /**
         * [참고]
         * 외부 컴포넌트와 통신 시
         * 정의해놓은 예외 코드 일 경우엔 적절하게 핸들링하여 처리한다.
         */
        if (httpStatus == HttpStatus.NOT_FOUND) {
            System.out.println("[DemoFeignErrorDecoder] Http Status = " + httpStatus);
            throw new RuntimeException(String.format("[RuntimeException] Http Status is %s", httpStatus));
        }

        return errorDecoder.decode(methodKey, response);
    }
}
```
