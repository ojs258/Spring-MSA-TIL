package com.example.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Order {
    private Long id;
    private String orderId;
    private Long count;
    private String userId;
    private String productId;
}
