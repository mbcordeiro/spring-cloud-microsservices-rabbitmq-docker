package com.matheuscordeiro.cardsapi.application.service.impl;

import com.matheuscordeiro.cardsapi.application.service.CardService;
import com.matheuscordeiro.cardsapi.domain.Card;
import com.matheuscordeiro.cardsapi.infra.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;

    @Override
    @Transactional
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCardsIncomeLessThanEqual(Long income) {
        return cardRepository.findByIncomeLessThanEqual(BigDecimal.valueOf(income));
    }
}
