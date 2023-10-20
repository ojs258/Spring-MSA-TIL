package com.example.orderservice.repository;

import com.example.orderservice.dto.ResponseOrderDto;
import com.example.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT new com.example.orderservice.dto.ResponseOrderDto(o) " +
            "FROM Order o " +
            "WHERE o.orderId = :orderId")
    Optional<ResponseOrderDto> findOrder(@Param("orderId") String orderId);
    @Query("SELECT new com.example.orderservice.dto.ResponseOrderDto(o) " +
            "FROM Order o")
    List<ResponseOrderDto> findOrders();
}
