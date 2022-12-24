
# gradle multi module 세팅하기


## 🍏 gradle multi module
- [[10분 테코톡] 루나의 Gradle](https://www.youtube.com/watch?v=ntOH2bWLWQs)
- [자바 빌드 도구](https://tecoble.techcourse.co.kr/post/2020-09-17-java-build-tool/)
- [Gradle 메뉴얼 - 멀티모듈](https://docs.gradle.org/current/userguide/multi_project_builds.html)
- [Gradle 멀티 프로젝트 관리 by 향로](https://jojoldu.tistory.com/123)
- [멀티모듈 설계이야기 by 권용근](https://techblog.woowahan.com/2637/)
- [우아한 멀티모듈 by 권용근](https://www.youtube.com/watch?v=nH382BcycHc&t=3733s)
- [인프콘 멀티모듈 프로젝트 구조와 설계 by 네이버 김대성](https://www.inflearn.com/course/infcon2022/unit/126503)



## 초기 세팅
java project 생성후 new module 로 추가


## 생성후 작업
root build.gradle 편집

```shell
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.0.0'
    id 'io.spring.dependency-management' version '1.1.0'
}

repositories {
    mavenCentral()
}

bootJar.enabled = false

subprojects {
    group = 'tk'
    version = '0.0.1-SNAPSHOT'
    sourceCompatibility = '17'

    apply plugin: 'java'
    // build.gradle에서 api() 를 사용하려면 java-library 사용
    apply plugin: 'java-library'
    apply plugin: 'org.springframework.boot'
    // spring boot dependency를 사용하여 사용중인 부트 버전에서 자동으로 의존성을 가져온다.
    apply plugin: 'io.spring.dependency-management'

    configurations {
        compileOnly {
            extendsFrom annotationProcessor
        }
    }

    repositories {
        mavenCentral()
    }

    // 관리하는 모듈에 공통 dependencies
    dependencies {
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }

    test {
        useJUnitPlatform()
    }
}
```

settins.gradle 편집
```shell
rootProject.name = 'multi-modules'

include 'shark-web', 'shark-simul', 'shark-common'

```


### 개별 module 의 build.gradle
```shell

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
}
```

### 불필요 파일 삭제
개별 모듈내에 gradle 관련 파일 모두 삭제, build.gradle 만 남기기
프로젝트 상위경로에 .idea 폴더 전체 삭제 후 새로 로딩


### 다른 모듈 참조하기 위한 세팅
```shell

dependencies {
    implementation(project(":shark-common"))
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-web'
}
```


### Configuration Injection
```shell

def javaProjects = [ // Java 로 작성된 소스코드에 대한 공통작업 선언
     project(":shark-common"),
     project(":shark-web"),
     project(":shark-simul"),
]
```
위와 같이 javaProjects 정의해두고 거기 모듈만 적용되는 내용 기재

```
configure(javaProjects) {
    group = 'tk'
    version = '1.0'
    sourceCompatibility = '17'

    apply plugin: 'java'
    // build.gradle에서 api() 를 사용하려면 java-library 사용
    apply plugin: 'java-library'
    apply plugin: 'org.springframework.boot'
    // spring boot dependency를 사용하여 사용중인 부트 버전에서 자동으로 의존성을 가져온다.
    apply plugin: 'io.spring.dependency-management'

    configurations {
        compileOnly {
            extendsFrom annotationProcessor
        }
    }

    // 관리하는 모듈에 공통 dependencies
    dependencies {
        compileOnly 'org.projectlombok:lombok'
        annotationProcessor 'org.projectlombok:lombok'
        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }

    test {
        useJUnitPlatform()
    }

}
```

### 실제 실행되지 않는 common 모듈의 build.gradle
```shell
tasks.bootJar { enabled = false }
tasks.jar { enabled = true }
```


### Gradle 빌드(module-api빌드 예시, info(로그레벨), Test코드 수행X)
```shell
- Gradle 빌드 명령어 :: root project
  -> ./gradlew clean :module-api:buildNeeded --stacktrace --info --refresh-dependencies -x test
```

### 모듈 패키지 구조가 달라서 ComponentScan 되지 않을 때 
- SpringBoot 실행 클래스 위치를 올려주는 방법
- 명시적으로 지정하는 방법(추천)
```
@SpringBootApplication(
        scanBasePackages = { "dev.be.moduleapi", "dev.be.modulecommon" }
)
```

```shell
/**
*[중요] `ModuleApiApplication` Package Path 변경 : 하위 Module에 존재하는 Bean Scan을 위한 조치
*
* ModuleApiApplication의 위치를 변경하는 방법이 아닌
* 명시적으로 Component Scan 범위 지정하여 Bean을 등록한다.
*
* scanBasePackages에서 Bean으로 등록할 Package Path를 지정해준다.
* 그런데 JPA와 관련된 Entity와 Repository는 여기서 Scan이 되지 않는다.
* 그래서 "@EntityScan, @EnableJpaRepositories" 어노테이션을 사용해서 등록을 시도해야 한다.
*
* 만약 JPA를 사용한다면
* "@EntityScan, @EnableJpaRepositories" 어노테이션을 사용해
* 필요한 Entity와 Repository를 Bean으로 등록한다.
* 이렇게 명시적으로 등록해주지 않으면 Entity와 Repository는 Bean으로 등록되지 않아
* 컴파일 시점에 Bean 주입이 실패했다는 에러가 발생한다.
*
* 그렇다면 scanBasePackages에서 "dev.be.modulecommon"을 등록하는 이유는 뭘까?
* 그 이유는 api module에서 common module에 있는 일반적인 Bean을 참조할 수 있으므로
* 그러한 Bean들을 Spring Container에 등록하기 위해 사용한다.
* ex) CommonDemoService.class
*/
@SpringBootApplication(
scanBasePackages = { "dev.be.moduleapi", "dev.be.modulecommon" }
)
@EntityScan("dev.be.modulecommon.domain")
@EnableJpaRepositories(basePackages = "dev.be.modulecommon.repositories")
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }
}
```
