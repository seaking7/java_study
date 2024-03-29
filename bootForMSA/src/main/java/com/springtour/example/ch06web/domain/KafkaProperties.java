package com.springtour.example.ch06web.domain;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@ConfigurationProperties(prefix = "springtour.kafka")
public class KafkaProperties {

    private List<String> bootstrapServers;
    private Integer ackLevel;
    private Topic topic;

    @ToString
    @Getter
    @Setter
    public static class Topic {
        private String checkout;
        private String reservation;
    }
}
