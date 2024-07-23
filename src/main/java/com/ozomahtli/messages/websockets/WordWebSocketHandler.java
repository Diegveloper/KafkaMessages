package com.ozomahtli.messages.websockets;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WordWebSocketHandler extends TextWebSocketHandler {
    private static final String[] words = {
            "apple","banana","cherry","orange","fig","grape"
    };
    private final Random random = new Random();
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void afterConnectionEstablished(WebSocketSession session)throws Exception{
        executorService.scheduleAtFixedRate(() -> sendRandomWord(session), 0, 3, TimeUnit.SECONDS);
    }

    private void sendRandomWord(WebSocketSession session){
        if(session.isOpen()){
            String word = words[random.nextInt(words.length)];
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session , CloseStatus status) throws Exception{
        executorService.shutdown();
    }
}
