package com.example.orderservice.dto;


import com.example.orderservice.entity.Order;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestOrderDto {

    @NotBlank
    private Long count;

    public Order toEntity(){
        return Order.builder()
                .orderId(UUID.randomUUID().toString())
                .count(count)
                .build();
    }
}
