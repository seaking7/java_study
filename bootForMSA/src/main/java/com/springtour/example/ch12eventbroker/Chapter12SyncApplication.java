package com.springtour.example.ch12eventbroker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.springtour.example.ch12eventbroker.event.server.ApplicationEventListener;
import com.springtour.example.ch12eventbroker.service.UserService;

@SpringBootApplication
public class Chapter12SyncApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(Chapter12SyncApplication.class);
        SpringApplication application = appBuilder.build();
        application.addListeners(new ApplicationEventListener());

        ConfigurableApplicationContext ctxt = application.run(args);

        UserService userService = ctxt.getBean(UserService.class);
        userService.createUser("Byungboo Kim", "test.com");
    }
}

