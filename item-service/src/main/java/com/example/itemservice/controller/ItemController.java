package com.example.itemservice.controller;

import com.example.itemservice.dto.RequestBuyItemDto;
import com.example.itemservice.dto.ResponseBuyItemDto;
import com.example.itemservice.service.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item-service")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    private final ObjectMapper om;
    @GetMapping("health-check")
    public String healthCheck() {
        return "healthy";
    }

    @PostMapping("/items")
    public ResponseEntity<?> resistItem(@RequestBody RequestBuyItemDto itemDto) {
        return itemService.resistItem(itemDto);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ResponseBuyItemDto>> findItems() {
        return itemService.findItems();
    }

    @GetMapping("/items/{productId}")
    public ResponseEntity<ResponseBuyItemDto> findItem(@PathVariable("productId") String productId) {
        return itemService.findItem(productId);
    }
    @GetMapping("/items/mq/{msg}")
    public ResponseEntity<String> getMqMessage(@PathVariable("msg") String message) throws InterruptedException {
        itemService.publishMessage(message);
        return ResponseEntity.ok().body("메세지 저장 완료");
    }

    @PostMapping("/items/create")
    public ResponseEntity<String> createItem(@RequestBody RequestBuyItemDto itemDto)
        throws  JsonProcessingException{
        itemService.createMessage(itemDto);
        return ResponseEntity.ok().body("메세지 저장 완료");
    }
}
