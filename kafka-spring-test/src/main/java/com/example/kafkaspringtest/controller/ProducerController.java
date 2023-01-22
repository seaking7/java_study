package com.example.kafkaspringtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaspringtest.domain.KafkaProduceService;
import com.example.kafkaspringtest.domain.MyMessage;

@RestController
public class ProducerController {

    @Autowired
    private KafkaProduceService kafkaProduceService;

    @GetMapping("/produce")
    public String publish(@RequestParam String message) {
        kafkaProduceService.send(message);
        return "published a message :" + message;
    }

    @RequestMapping("/publish2")
    public String publishWithCallback(String message) {
        kafkaProduceService.sendWithCallback(message);
        return "published a message with callback :" + message;
    }

    @RequestMapping("/publish3")
    public String publishJson(MyMessage message) {
        kafkaProduceService.sendJson(message);
        return "published a message with callback :" + message.getName() + "," + message.getMessage();
    }
}
