package com.example.kafkatest.application;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.stereotype.Service;

@Service
public class KafkaProduceFacade {

	private final static String BOOTSTRAP_SERVER = "localhost:9092";

	private final static String TOPIC_NAME = "topic5";


	public String kafkaProduce(String message) throws ExecutionException, InterruptedException {


		Properties configs = new Properties();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.ACKS_CONFIG, "all");
		configs.put(ProducerConfig.RETRIES_CONFIG, "100");

		org.apache.kafka.clients.producer.KafkaProducer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<>(configs);

		ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, message);

		RecordMetadata metadata = producer.send(record).get();

		System.out.printf(">>> %s, %d, %d", message, metadata.partition(), metadata.offset());

		producer.flush();
		producer.close();

		return "Ok";

	}
}
