package com.matheuscordeiro.creditappraiserapi.application.service.impl;

import com.matheuscordeiro.creditappraiserapi.application.service.CreditAppraiserService;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCredit;
import com.matheuscordeiro.creditappraiserapi.infa.client.CardClient;
import com.matheuscordeiro.creditappraiserapi.infa.client.CustomerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditAppraiserServiceImpl implements CreditAppraiserService {
    private final CustomerClient customerClient;
    private final CardClient cardClient;

    @Override
    public CustomerCredit retrieveCustomerCredit(String document) {
        final var customerData = customerClient.getByDocument(document);
        final var customerCard = cardClient.getCardByCustomer(document);
        return CustomerCredit.builder().customerData(customerData.getBody()).customerCards(customerCard.getBody()).build();
    }
}