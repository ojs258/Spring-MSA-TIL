package com.example.orderservice.dto;


import com.example.orderservice.entity.Order;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseOrderDto {
    private String productName;
    private Long count;
    private Long totalPrice;

    public ResponseOrderDto(Order order) {
    }

    public ResponseOrderDto toDto(Order order) {
        return new ResponseOrderDto(order);
    }
}
