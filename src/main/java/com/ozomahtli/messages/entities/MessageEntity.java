package com.ozomahtli.messages.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class MessageEntity {
    private @Id
    @GeneratedValue Long id;
    private String key;
    private String message;

    public MessageEntity() {}  // default constructor for JPA

    public MessageEntity(String key, String message){
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
