package com.springtour.example.ch09restapi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springtour.example.ch09restapi.adapter.PoolingBillingAdapter;
import com.springtour.example.ch09restapi.controller.CreateCodeResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Chapter09WebApplication2 {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctxt =
                SpringApplication.run(Chapter09WebApplication2.class, args);

        PoolingBillingAdapter billingAdapter = ctxt.getBean(PoolingBillingAdapter.class);

        CreateCodeResponse codeResponse =
                billingAdapter.createBillingCode(List.of(19000L, 18000L, 17000L));
        log.info("Result : {}", codeResponse);
    }
}
