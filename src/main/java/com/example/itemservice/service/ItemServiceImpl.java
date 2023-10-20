package com.example.itemservice.service;

import com.example.itemservice.dto.RequestBuyItemDto;
import com.example.itemservice.dto.ResponseBuyItemDto;
import com.example.itemservice.entity.Item;
import com.example.itemservice.exception.ItemNotFoundException;
import com.example.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
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
}
