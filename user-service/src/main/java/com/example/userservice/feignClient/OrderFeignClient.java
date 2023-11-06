package com.example.userservice.feignClient;

import com.example.userservice.domain.Order;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ORDER-SERVICE", path = "order-service")
public interface OrderFeignClient {
    @GetMapping("/orders/{userId}")
    public List<Order> getOrderListByUserId(@PathVariable("userId") String userId);
}
