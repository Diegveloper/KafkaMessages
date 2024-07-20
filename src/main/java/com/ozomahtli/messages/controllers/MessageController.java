package com.ozomahtli.messages.controllers;

import com.ozomahtli.messages.dto.MessageDto;
import com.ozomahtli.messages.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private KafkaProducerService kfkSrv;

    @PostMapping
    public String receiveMessage(@RequestBody MessageDto msg){
        kfkSrv.sendMessage(msg.getMessage());
        System.out.println(msg.getMessage());
        return "200";
    }
}
