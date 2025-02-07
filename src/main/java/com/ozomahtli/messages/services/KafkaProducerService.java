package com.ozomahtli.messages.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "messages";
    public void sendMessage(String key, String message){
        kafkaTemplate.send(TOPIC, key, message);
    }
}
