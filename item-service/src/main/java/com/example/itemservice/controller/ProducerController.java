package com.example.itemservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("kafka")
@Slf4j
public class ProducerController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic sampleTopic1;
    @Autowired
    public ProducerController(KafkaTemplate<String, String> kafkaTemplate, NewTopic sampleTopic1) {
        this.kafkaTemplate = kafkaTemplate;
        this.sampleTopic1 = sampleTopic1;
    }

    @GetMapping("/publish/sampleTopic1")
    public String publishSpringTopic() {
        String message = "publish message to my_topic_1 " + UUID.randomUUID();

        CompletableFuture.supplyAsync(() -> kafkaTemplate.send(sampleTopic1.name(), message))
        .whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[" + message + result.completable() + "]");
            } else {
                log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(sampleTopic1.name(), message);
        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                log.info("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
        return "done";
    }
}
