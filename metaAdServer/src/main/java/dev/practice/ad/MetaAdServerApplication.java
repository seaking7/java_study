package dev.practice.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class MetaAdServerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MetaAdServerApplication.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }

}
