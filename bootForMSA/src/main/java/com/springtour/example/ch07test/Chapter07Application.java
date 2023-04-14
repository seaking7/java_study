package com.springtour.example.ch07test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springtour.example.ch07test.controller.HotelRequest;
import com.springtour.example.ch07test.service.DisplayService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class Chapter07Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctxt = SpringApplication.run(Chapter07Application.class, args);
        DisplayService displayService = ctxt.getBean(DisplayService.class);
        displayService.getHotelsByName(new HotelRequest("Ragged Point Inn"))
                .stream()
                .forEach(hotelResponse -> log.info("response:{}", hotelResponse));

    }
}
