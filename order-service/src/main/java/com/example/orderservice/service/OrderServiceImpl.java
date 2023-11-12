package com.example.orderservice.service;

import com.example.orderservice.dto.RequestOrderDto;
import com.example.orderservice.dto.ResponseOrderDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    @Override
    public ResponseEntity<String> createOrder(RequestOrderDto orderDto) {
        orderRepository.save(orderDto.toEntity());
        return ResponseEntity.status(HttpStatus.OK).body("주문 성공");
    }

    @Override
    public ResponseEntity<ResponseOrderDto> findOrder(String productId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderRepository.findOrder(productId)
                .orElseThrow(OrderNotFoundException::new));
    }

    @Override
    public ResponseEntity<List<ResponseOrderDto>> findOrders() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderRepository.findOrders());
    }

    @Override
    public ResponseEntity<List<Order>> findOrdersByUserId(String userId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderRepository.findOrdersByUserId(userId));
    }
}
