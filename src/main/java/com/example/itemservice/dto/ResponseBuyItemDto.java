package com.example.itemservice.dto;


import com.example.itemservice.entity.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseBuyItemDto {
    private String productId;
    private String productName;
    private Long stock;
    private Long pricePerItem;
    private Long totalPrice;

    public ResponseBuyItemDto(Item item) {
        productId = item.getProductId();
        productName = item.getProductName();
        stock = item.getStock();
        pricePerItem = item.getPricePerItem();
        totalPrice = item.getStock() * item.getPricePerItem();
    }

    // Repository로직이 사용하는 중
    public ResponseBuyItemDto toDto(Item item) {
        return new ResponseBuyItemDto(item);
    }
}
