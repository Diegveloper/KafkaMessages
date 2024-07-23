package com.ozomahtli.messages.dto;

import java.time.LocalDateTime;

public class MessageDto {
    private String key;
    private String message;

    public MessageDto(){}
    public MessageDto(String key, String message){
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        LocalDateTime dateTime = LocalDateTime.now();

        return "[" + dateTime +"]: "+ message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
