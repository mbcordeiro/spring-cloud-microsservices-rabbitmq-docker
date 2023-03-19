package com.matheuscordeiro.cardsapi.application.service;

import com.matheuscordeiro.cardsapi.domain.Card;

import java.util.List;

public interface CardService {
    Card save(Card card);

    List<Card> getCardsIncomeLessThanEqual(Long income);
}
