package com.example.apigatewayserver.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
//    @Bean
//    public RouteLocator gatewayLocator(RouteLocatorBuilder builder) {
//        return builder.routes() // 라우팅 정보 등록 시작
//                // 개별 서버별 라우팅정보를 등록하는 route메서드
//                .route(r ->
//                        r.path("/first-service/**")
//                            .filters(f -> f.addRequestHeader("HeaderRequestName", "HeaderRequestValue")
//                                    .addResponseHeader("HeaderResponseName", "HeaderResponseValue"))
//                                .uri("http://localhost:8001/")
//                ).route(r ->
//                        r.path("/first-service/**")
//                                .filters(f -> f.addRequestHeader("HeaderRequestName", "HeaderRequestValue")
//                                        .addResponseHeader("HeaderResponseName", "HeaderResponseValue"))
//                                .uri("http://localhost:8002/")
//                ).build(); // 라우팅 정보 등록 종료
//    }
}
