package com.springtour.example.ch08jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springtour.example.ch08jpa.server.UserIdInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public UserIdInterceptor userIdInterceptor() {
        return new UserIdInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userIdInterceptor());
    }
}
