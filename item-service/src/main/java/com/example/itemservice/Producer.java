package com.example.itemservice;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Proceducer {
    private final RabbitTemplate rabbitTemplate;

    public void messageProducer(String message){
        rabbitTemplate.convertAndSend("testQueue","testMessage");
    }
}
