package com.example.itemservice.repository;

import com.example.itemservice.dto.ResponseBuyItemDto;
import com.example.itemservice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("SELECT new com.example.itemservice.dto.ResponseBuyItemDto(i) " +
            "FROM Item i " +
            "WHERE i.productId = :productId")
    Optional<ResponseBuyItemDto> findItem(@Param("productId") String productId);
    @Query("SELECT new com.example.itemservice.dto.ResponseBuyItemDto(i) " +
            "FROM Item i")
    List<ResponseBuyItemDto> findItems();
}
