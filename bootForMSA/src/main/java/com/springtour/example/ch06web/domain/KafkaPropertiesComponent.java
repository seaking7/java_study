package com.springtour.example.ch06web.domain;

import org.springframework.stereotype.Component;

@Component
public class KafkaPropertiesComponent {

    private final KafkaProperties kafkaProperties;

    public KafkaPropertiesComponent(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
        System.out.println(kafkaProperties.toString());
    }
}
