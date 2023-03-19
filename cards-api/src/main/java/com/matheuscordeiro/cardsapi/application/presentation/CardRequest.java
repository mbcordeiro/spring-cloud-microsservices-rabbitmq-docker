package com.matheuscordeiro.cardsapi.application.presentation;

import com.matheuscordeiro.cardsapi.domain.Card;
import com.matheuscordeiro.cardsapi.domain.PaymentGroup;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardRequest {
    private String name;
    private PaymentGroup paymentGroup;
    private BigDecimal income;
    private BigDecimal limit;

    public Card toCard() {
        return new Card(name, paymentGroup, income, limit);
    }
}