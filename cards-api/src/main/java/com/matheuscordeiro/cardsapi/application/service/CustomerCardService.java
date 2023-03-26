package com.matheuscordeiro.cardsapi.application.service;

import com.matheuscordeiro.cardsapi.domain.CustomerCard;

import java.util.List;

public interface CustomerCardService {
    List<CustomerCard> findListCardByDocument(String document);
}
