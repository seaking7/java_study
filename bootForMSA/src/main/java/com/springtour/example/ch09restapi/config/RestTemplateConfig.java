package com.springtour.example.ch09restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.springtour.example.ch09restapi.server.IdentityHeaderInterceptor;

@Configuration
public class RestTemplateConfig {

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(3000);
        factory.setReadTimeout(1000);
        factory.setBufferRequestBody(false);

        return factory;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {

        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

        restTemplate.getInterceptors().add(new IdentityHeaderInterceptor());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

        return restTemplate;
    }
}
