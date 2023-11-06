package com.example.itemservice.service;

import com.example.itemservice.Producer;
import com.example.itemservice.dto.RequestBuyItemDto;
import com.example.itemservice.dto.ResponseBuyItemDto;
import com.example.itemservice.entity.Item;
import com.example.itemservice.exception.ItemNotFoundException;
import com.example.itemservice.repository.ItemRepository;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;
    private final Producer producer;
    private final ObjectMapper om;
    @Override
    @Transactional
    public ResponseEntity<String> resistItem(RequestBuyItemDto itemDto) {
        Item entity = itemDto.toEntity();
        Item save = itemRepository.save(entity);
        System.out.println("save = " + save);
        return ResponseEntity.status(HttpStatus.CREATED).body("등록 성공");
    }

    @Override
    public ResponseEntity<ResponseBuyItemDto> findItem(String productId) {
        return ResponseEntity.status(HttpStatus.OK)
            .body(
                itemRepository.findItem(productId)
                .orElseThrow(ItemNotFoundException::new)
            );
    }

    @Override
    public ResponseEntity<List<ResponseBuyItemDto>> findItems() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemRepository.findItems());
    }

    @Override
    public void publishMessage(String message){
        producer.messageProducer(message);

    }

    @Override
    public void createMessage(RequestBuyItemDto itemDto) throws JsonProcessingException {
        producer.messageProducer(om.writeValueAsString(itemDto));
    }
}
