package com.example.itemservice.dto;


import com.example.itemservice.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBuyItemDto {

    @NotBlank
    private String productName;

    @NotBlank
    private Long stock;

    @NotBlank
    private Long pricePerItem;

    public Item toEntity(){
        return Item.builder()
                .productName(productName)
                .stock(stock)
                .pricePerItem(pricePerItem)
                .build();
    }
}
