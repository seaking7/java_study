# SpringAsync


## 별도 Thread 정의, destroyMethod 는 SpringBoot 종료시 동작 정의
```java
@Configuration
@EnableAsync
public class AsyncConfig {
}
```
```java
@Configuration
public class AppConfig {

    @Bean(name = "defaultTaskExecutor", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor defaultTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(200);
        return executor;
    }

    @Bean(name = "messagingTaskExecutor", destroyMethod = "shutdown")
    public ThreadPoolTaskExecutor messagingTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(200);
        executor.setMaxPoolSize(200);
        return executor;
    }
}
```

## @Async는 별도 Bean으로 정의해야 함
```java
public class AsyncService {

    private final EmailService emailService;

    /**
     * 올바른 사용법
     */
    public void asyncCall_1() {
        System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    /**
     * @Async 는 별도 Bean으로 돌려야 한다
     */
    public void asyncCall_2() {
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());
        EmailService email₩Service = new EmailService();
        emailService.sendMail();
        emailService.sendMailWithCustomThreadPool();
    }

    public void asyncCall_3() {
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
        sendMail();
    }

    /**
     * 같은 Bean안에서는 proxy객체로 wrapping처리가 되지 않아 Aysnc로 동작하지 않는다
     */
    @Async
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }
}

```

```java
@Service
@RequiredArgsConstructor
public class EmailService {

    @Async("defaultTaskExecutor")
    public void sendMail() {
        System.out.println("[sendMail] :: "
                           + Thread.currentThread().getName());
    }

    @Async("messagingTaskExecutor")
    public void sendMailWithCustomThreadPool() {
        System.out.println("[sendMailWithCustomThreadPool] :: "
                           + Thread.currentThread().getName());
    }
}
```
