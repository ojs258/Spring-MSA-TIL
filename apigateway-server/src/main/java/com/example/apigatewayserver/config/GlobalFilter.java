package com.example.apigatewayserver.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {
    public GlobalFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();
            log.info("global filter default message : " + config.getMessage());

            if (config.isPre()) {
                log.info("global pre filter {}", request.getId());
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("global post filter : {}",response.getStatusCode());
            }));
        });
    }

    @Getter
    @AllArgsConstructor
    public static class Config {
        private String message;
        private boolean pre;
        private boolean post;
    }
}
