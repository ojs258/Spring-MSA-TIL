package com.example.resil.circuit_breaker_ex;

import com.example.resil.exception.CircuitBreakerException;
import com.example.resil.exception.IgnoreException;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
    // fallback 메서드의 2번째 매개변수인 Exception의 타입을 변경해 오버로딩을 통해
    // 다양하게 처리해 줄 수 있다.
//    private String fallback(String  param, Exception e) {
//        System.out.println(param+"요청을 처리하려고 했지만, 실패 한도까지 실패했습니다.");
//        return "처리됨 : " + e.toString();
//    }
// 아래와 같이 익셉션 마다 처리 방식을 지정하는 WhiteList방식이 좋아보인다.
    private String fallback(String  param, IgnoreException e) {
        log.info(param+"요청을 처리하려고 했지만, 실패 했습니다.");
        return "처리 실패 : " + e.toString();
    }

    private String fallback(String  param, CircuitBreakerException e) {
        log.info("예외가 발생했지만 무시할 수 있어, "+param+"을 처리했습니다.");
        return "처리됨 : " + e.toString();
    }

    private String fallback(String  param, CallNotPermittedException e) {
        log.info(param+"요청을 처리하려고 했지만, OPEN상태 입니다.");
        return "처리 실패 : " + e.toString();
    }

    private String callFeignClient(String param) {
        if ("a".equals(param)) {
            throw new CircuitBreakerException("실패!!");
        } else if ("b".equals(param)){
            throw new IgnoreException("가즈ACK");
        } else if ("c".equals(param)) {
            throw new NullPointerException();
        }
        return param;
    }
}
