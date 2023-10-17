package com.example.apigatewayserver.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class CustomFilter2 extends AbstractGatewayFilterFactory<CustomFilter2.Config> {
    public CustomFilter2() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();
            log.info("Custom2 pre filter : {}",request.getId());

            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                log.info("Custom2 post filter : {}",request.getId());
            }));
        });
    }

    public static class Config {
    }
}
