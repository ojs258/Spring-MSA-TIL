package com.example.orderservice.service;

import com.example.orderservice.dto.RequestOrderDto;
import com.example.orderservice.dto.ResponseOrderDto;
import com.example.orderservice.entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<String> createOrder(RequestOrderDto orderDto);
    ResponseEntity<ResponseOrderDto> findOrder(String productId);
    ResponseEntity<List<ResponseOrderDto>> findOrders();
    ResponseEntity<List<Order>> findOrdersByUserId(String userId);
}
