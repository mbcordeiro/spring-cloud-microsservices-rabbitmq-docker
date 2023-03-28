package com.matheuscordeiro.creditappraiserapi.application.service.impl;

import com.matheuscordeiro.creditappraiserapi.application.exception.CustomerDataNotFoundException;
import com.matheuscordeiro.creditappraiserapi.application.service.CreditAppraiserService;
import com.matheuscordeiro.creditappraiserapi.domain.*;
import com.matheuscordeiro.creditappraiserapi.infa.client.CardClient;
import com.matheuscordeiro.creditappraiserapi.infa.client.CustomerClient;
import com.matheuscordeiro.creditappraiserapi.infa.queue.CreditIssuePublisher;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditAppraiserServiceImpl implements CreditAppraiserService {
    private final CustomerClient customerClient;
    private final CardClient cardClient;

    private final CreditIssuePublisher creditIssuePublisher;

    @Override
    public CustomerCredit retrieveCustomerCredit(String document) throws CustomerDataNotFoundException {
        try {
            final var customerData = customerClient.getByDocument(document);
            final var customerCard = cardClient.getCardByCustomer(document);
            return CustomerCredit.builder().customerData(customerData.getBody()).customerCards(customerCard.getBody()).build();
        } catch (FeignException.FeignClientException e) {
            if (HttpStatus.NOT_FOUND.value() == e.status()) {
                throw new CustomerDataNotFoundException();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerCreditResponse createCustomerCredit(String document, Long income) throws CustomerDataNotFoundException {
        try {
            final var customerData = customerClient.getByDocument(document);
            final var cardList = cardClient.getCardByIncome(income);
            final var approvedCardList = Objects.requireNonNull(cardList.getBody()).stream().map(card -> {
                final var approvedLimit = calculateApprovedLimit(Objects.requireNonNull(customerData.getBody()), card);
                return getApprovedCard(card, approvedLimit);
            }).collect(Collectors.toList());
            return new CustomerCreditResponse(approvedCardList);
        } catch (FeignException.FeignClientException e) {
            if (HttpStatus.NOT_FOUND.value() == e.status()) {
                throw new CustomerDataNotFoundException();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public RequestCardProtocol requestCard(CreditIssueRequest creditIssueRequest) {
        try {
            creditIssuePublisher.requestCard(creditIssueRequest);
            final var protocol = UUID.randomUUID().toString();
            return new RequestCardProtocol(protocol);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private ApprovedCard getApprovedCard(Card card, BigDecimal approvedLimit) {
       return ApprovedCard.builder()
               .card(card.getName()).paymentGroup(card.getPaymentGroup()).limit(approvedLimit).build();
    }

    private BigDecimal calculateApprovedLimit(CustomerData customerData, Card card) {
        final var age =  BigDecimal.valueOf(customerData.getAge());
        final var limit = card.getLimit();
        final var quotient = age.divide(BigDecimal.TEN, 0, RoundingMode.HALF_UP);
        return quotient.multiply(limit);
    }
}