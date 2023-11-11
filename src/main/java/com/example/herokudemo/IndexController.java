package com.example.herokudemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.herokudemo.KafkaProducerService;

@RestController
public class IndexController {
    @Autowired
    private KafkaProducerService producerService;

    @GetMapping("/")
    public String index() {
        return "Hello there! I'm running.";
    }
    @GetMapping("/produce")
    public String produceMessage(@RequestParam String message) {
        producerService.produceMessage(message);
        return "Message sent to Kafka!";
    }
}
