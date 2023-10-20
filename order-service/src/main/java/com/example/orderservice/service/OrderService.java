package com.example.orderservice.service;

import com.example.orderservice.dto.RequestOrderDto;
import com.example.orderservice.dto.ResponseOrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<String> createOrder(RequestOrderDto orderDto);

    ResponseEntity<ResponseOrderDto> findItem(String productId);

    ResponseEntity<List<ResponseOrderDto>> findItems();
}