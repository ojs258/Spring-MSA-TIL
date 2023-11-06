package com.example.itemservice;

import com.example.itemservice.dto.RequestBuyItemDto;
import com.example.itemservice.repository.ItemRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Consumer {
    private final ObjectMapper om;
    private final ItemRepository itemRepository;
//    @RabbitListener(queues = "testQueue")
//    public void getTestMessage(String message) {
//        System.out.println("message = " + message);
//    }

    @RabbitListener(queues = "testQueue")
    public void getTestMessage(String message) throws JsonProcessingException {
        itemRepository.save(om.readValue(message,RequestBuyItemDto.class).toEntity());
    }
}
