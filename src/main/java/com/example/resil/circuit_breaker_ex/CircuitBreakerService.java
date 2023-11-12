package com.example.resil.circuit_breaker_ex;

import com.example.resil.exception.CircuitBreakerException;
import com.example.resil.exception.IgnoreException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerService {
    private static final String CIRCUIT_BREAKER_CONFIG = "circuitBreakerConfig";

    // @CircuitBreaker를 이용해 해상 메서드에 회로 차단기 역할을 부여한다.
    @CircuitBreaker(name = CIRCUIT_BREAKER_CONFIG,fallbackMethod = "fallback")
    public String process(String param){
        return callFeignClient(param);
    }

    // 예외 발생에 따라
    // CircuitBreakerException이라면
    // CircuitBreaker로직(Close -> Open 으로 가는 임계치 카운팅) 진행 후 fallback 메서드 진행
    // IgnoreException이라면 CircuitBreaker로직 없이 바로 fallback 메서드로 진행된다.
    private String fallback(String  param, Exception e) {
        System.out.println(param+"요청을 처리하려고 했지만, 실패 한도까지 실패했습니다.");
        return "처리됨 : " + e.toString();
    }

    private String callFeignClient(String param) {
        if ("a".equals(param)) {
            throw new CircuitBreakerException("실패!!");
        } else if ("b".equals(param)){
            throw new IgnoreException("가즈ACK");
        }
        return param;
    }
}
