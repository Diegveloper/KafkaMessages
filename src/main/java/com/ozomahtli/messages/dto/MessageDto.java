package com.ozomahtli.messages.dto;

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
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
