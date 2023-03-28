package com.matheuscordeiro.cardsapi.infra.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheuscordeiro.cardsapi.domain.Card;
import com.matheuscordeiro.cardsapi.domain.CreditIssueRequest;
import com.matheuscordeiro.cardsapi.domain.CustomerCard;
import com.matheuscordeiro.cardsapi.infra.repository.CardRepository;
import com.matheuscordeiro.cardsapi.infra.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
@RequiredArgsConstructor
public class CardIssueSubscriber {
    private final CardRepository cardRepository;

    private final CustomerCardRepository customerCardRepository;

    @RabbitListener(queues = "${mq.queues.cards-issue}")
    @Transactional
    public void subscribe(@Payload String payload) {
        final var mapper = new ObjectMapper();
        try {
            final var creditIssueRequest = mapper.readValue(payload, CreditIssueRequest.class);
            final var card = cardRepository.findById(creditIssueRequest.getId()).orElseThrow();
            final var customerCard = getCustomerCard(creditIssueRequest, card);
            customerCardRepository.save(customerCard);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private CustomerCard getCustomerCard(CreditIssueRequest creditIssueRequest, Card card) {
        return CustomerCard.builder()
                .card(card).document(creditIssueRequest.getDocument()).limit(creditIssueRequest.getLimit()).build();
    }
}