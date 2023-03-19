package com.matheuscordeiro.cardsapi.infra.repository;

import com.matheuscordeiro.cardsapi.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
