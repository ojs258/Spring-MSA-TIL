package com.example.resil;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// 메인메서드를 담당하는 어플리케이션을 하나의 프로잭트 내에 두개 이상 생성할 수 있습니다.
// 이 경우 어떤 메인메서드를 실행하는지에 따라 주입되는 빈의 종류를 다르게..
@SpringBootApplication
@Slf4j
public class ResilLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResilLogApplication.class, args);
    }

    @Bean
    public RegistryEventConsumer<CircuitBreaker> consumer(){
        return new RegistryEventConsumer<CircuitBreaker>() {
            @Override
            public void onEntryAddedEvent(EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
                // 이벤트 발생, 실패정도도 가능하지만
//                log.info("RegistryEventConsumer의 onEntryAddEvent발생");
//                entryAddedEvent.getAddedEntry()
//                        .getEventPublisher()
//                        .onEvent(e -> log.info("{}",e.getEventType()));
//                entryAddedEvent.getAddedEntry()
//                        .getEventPublisher()
//                        .onFailureRateExceeded(e -> log.info("{}",e.getEventType()));
                // 좀 더 상세하게 로깅 처리 가능
                CircuitBreaker.EventPublisher eventPublisher = entryAddedEvent.getAddedEntry().getEventPublisher();
                eventPublisher.onEvent(e -> log.info("onEvent {}",e.getEventType()));
                eventPublisher.onFailureRateExceeded(e -> log.info("onFail{}",e.getEventType()));
                eventPublisher.onCallNotPermitted(e -> log.info("onCallNotPermitted{}",e.getEventType()));
                eventPublisher.onStateTransition(e -> log.info("onStateTransition{}",e.getEventType()));
                eventPublisher.onSuccess(e -> log.info("onSuccess{}",e.getEventType()));
            }

            @Override
            public void onEntryRemovedEvent(EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {

            }

            @Override
            public void onEntryReplacedEvent(EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {

            }
        };
    };

}
