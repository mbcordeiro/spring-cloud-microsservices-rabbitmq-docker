package com.matheuscordeiro.creditappraiserapi.infa.queue.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheuscordeiro.creditappraiserapi.domain.CreditIssueRequest;
import com.matheuscordeiro.creditappraiserapi.infa.queue.CreditIssuePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditIssuePublisherImpl implements CreditIssuePublisher {
    private final RabbitTemplate rabbitTemplate;
    private Queue queue;

    @Override
    public void requestCard(CreditIssueRequest creditIssueRequest) throws JsonProcessingException {
        final var json = convertIntoJson(creditIssueRequest);
        rabbitTemplate.convertAndSend(queue.getName(), json);
    }

    private String convertIntoJson(CreditIssueRequest creditIssueRequest) throws JsonProcessingException {
        final var mapper = new ObjectMapper();
        return mapper.writeValueAsString(creditIssueRequest);
    }
}
