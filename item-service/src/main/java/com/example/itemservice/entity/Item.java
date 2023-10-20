package com.example.itemservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;

    private String productName;

    private Long stock;

    private Long pricePerItem;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    @PrePersist
    private void createProductId(){
        productId = String.valueOf(UUID.randomUUID());
    }
}
