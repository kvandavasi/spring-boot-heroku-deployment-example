package com.example.herokudemo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumerService {

    private static final String TOPIC = "my-topic";

    @KafkaListener(topics = TOPIC, groupId = "my-group")
    public void consumeMessage(String message) {
        System.out.println("Message received: " + message);
    }
}
