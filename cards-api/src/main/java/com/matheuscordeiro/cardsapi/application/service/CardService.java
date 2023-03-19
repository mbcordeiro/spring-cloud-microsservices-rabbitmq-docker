package com.matheuscordeiro.cardsapi.application.service;

import com.matheuscordeiro.cardsapi.domain.Card;

import java.math.BigDecimal;
import java.util.List;

public interface CardService {
    void save(Card card);

    List<Card> findCardsByIncomeLessThanEqual(BigDecimal income);
}
