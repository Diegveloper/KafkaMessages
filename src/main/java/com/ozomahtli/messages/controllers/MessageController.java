package com.ozomahtli.messages.controllers;

import com.ozomahtli.messages.dto.MessageDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @PostMapping
    public String receiveMessage(@RequestBody MessageDto msg){
        System.out.println(msg.getMessage());
        return "200";
    }
}
