package com.example.itemservice.service;

import com.example.itemservice.dto.RequestBuyItemDto;
import com.example.itemservice.dto.ResponseBuyItemDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ResponseEntity<String> resistItem(RequestBuyItemDto itemDto);

    ResponseEntity<ResponseBuyItemDto> findItem(String productId);

    ResponseEntity<List<ResponseBuyItemDto>> findItems();

    void publishMessage(String message);
    void createMessage(RequestBuyItemDto itemDto) throws JsonProcessingException;
}
