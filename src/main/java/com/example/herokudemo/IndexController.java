package com.example.herokudemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }

    private final KafkaProducerService producerService;

    public IndexController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/produce")
    public String produceMessage(@RequestParam String message) {
        producerService.produceMessage(message);
        return "Message sent to Kafka!";
    }
}
