package com.example.kafkatest.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkatest.application.KafkaConsumeFacade;
import com.example.kafkatest.application.KafkaProduceFacade;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {


	private final KafkaProduceFacade kafkaProduceFacade;
	private final KafkaConsumeFacade kafkaConsumeFacade;

	@GetMapping("/produce")
	public String testKafka(@RequestParam String message) throws ExecutionException, InterruptedException {

		String returnMessage = kafkaProduceFacade.kafkaProduce(message);


		return returnMessage;
	}

	@GetMapping("/consume")
	public String testConsume(){
		return kafkaConsumeFacade.kafkaConsumeMessage();
	}
}
