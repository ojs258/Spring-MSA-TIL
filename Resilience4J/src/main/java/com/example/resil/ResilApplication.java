package com.example.resil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 메인메서드를 담당하는 어플리케이션을 하나의 프로잭트 내에 두개 이상 생성할 수 있습니다.
// 이 경우 어떤 메인메서드를 실행하는지에 따라 주입되는 빈의 종류를 다르게..
@SpringBootApplication
public class ResilApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResilApplication.class, args);
    }

}
