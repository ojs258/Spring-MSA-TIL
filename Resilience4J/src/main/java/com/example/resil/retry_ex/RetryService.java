package com.example.resil.retry_ex;

import com.example.resil.exception.IgnoreException;
import com.example.resil.exception.RetryException;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class RetryService {
    private static final String CONFIG_CLASS_NAME = "retryConfig";

    // @Retry어노테이션을 이용한 재시도 로직
    // 재시도에 대한 구체적인 로직은 CONFIG_CLASS_NAME의 class에 작성
    @Retry(name = CONFIG_CLASS_NAME, fallbackMethod = "fallback")
    public String process(String param) {
        return callAnotherServer(param);
    }

    // 예외 발생에 따라
    // RetryException이라면 재시도 로직 진행 후 fallback 메서드 진행
    // IgnoreException이라면 재시도 로직 없이 바로 fallback 메서드로 진행된다.
    private String fallback(String  param, Exception e) {
        System.out.println(param+"요청을 처리하려고 했지만, 실패 한도까지 실패했습니다.");
        return "처리됨 : " + e.toString();
    }

    private String callAnotherServer(String param) {
        if (param.equals("qwer")){
            throw new RetryException("재시도 예외");
        }else {
            throw new IgnoreException("가보자");
        }
    }

}
