package com.matheuscordeiro.cardsapi.application.service.impl;

import com.matheuscordeiro.cardsapi.application.service.CustomerCardService;
import com.matheuscordeiro.cardsapi.domain.CustomerCard;
import com.matheuscordeiro.cardsapi.infra.repository.CustomerCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerCardServiceImpl implements CustomerCardService {
    private final CustomerCardRepository repository;

    @Override
    public List<CustomerCard> findListCardByDocument(String document) {
        return repository.findByDocument(document);
    }
}