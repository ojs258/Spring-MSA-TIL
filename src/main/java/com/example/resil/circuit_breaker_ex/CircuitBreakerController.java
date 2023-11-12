package com.example.resil.circuit_breaker_ex;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cb")
@RequiredArgsConstructor
public class CircuitBreakerController {
    private final CircuitBreakerService circuitBreakerService;

    @GetMapping("hello/{param}")
    public String call(@PathVariable("param")String param) {
        return circuitBreakerService.process(param);
    }
}
