package com.example.firstservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("first-service")
@RequiredArgsConstructor
public class HelloController {

    private final Environment env;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello, First-service!";
    }

    @GetMapping("header-check")
    public String headerCheck(@RequestHeader("HeaderRequest") String header){
        return header;
    }
    @GetMapping("port-check")
    public String portCheck(){
        // 그냥 server.port로 하면 랜덤배정을위해 yml 파일에 기입한 0이 나옴
        return env.getProperty("local.server.port")
                + " // "
                + env.getProperty("test.value")
                + "진석 시치 키보드 개 구데기...";
    }
}
