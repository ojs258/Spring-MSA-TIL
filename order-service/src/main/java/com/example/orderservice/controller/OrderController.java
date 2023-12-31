package com.example.orderservice.controller;

import com.example.orderservice.dto.RequestOrderDto;
import com.example.orderservice.dto.ResponseOrderDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order-service")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("health-check")
    public String healthCheck() {
        return "healthy";
    }

    @PostMapping("/orders")
    public ResponseEntity<?> createOrder(@RequestBody RequestOrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<ResponseOrderDto> findOrder(@PathVariable("orderId") String orderId) {
        return orderService.findOrder(orderId);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<ResponseOrderDto>> findOrders() {
        return orderService.findOrders();
    }



    @GetMapping("/orders/{userId}")
    public ResponseEntity<List<Order>> findOrders(@PathVariable("userId") String userId) {
        return orderService.findOrdersByUserId(userId);
    }
}
