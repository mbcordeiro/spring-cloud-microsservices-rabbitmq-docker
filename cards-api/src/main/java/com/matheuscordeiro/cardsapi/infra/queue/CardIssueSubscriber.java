package com.matheuscordeiro.cardsapi.infra.queue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardIssueSubscriber {
    @RabbitListener(queues = "${mq.queues.cards-issue}")
    public void subscribe(@Payload String payload) {
        log.info(payload);
    }
}