package com.matheuscordeiro.cardsapi.infra.repository;

import com.matheuscordeiro.cardsapi.domain.CustomerCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerCardRepository extends JpaRepository<CustomerCard, Long> {
    List<CustomerCard> findByDocument(String document);
}