package com.matheuscordeiro.cardsapi.application.presentation;

import com.matheuscordeiro.cardsapi.domain.CustomerCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCardResponse {
    private String name;
    private String paymentGroup;
    private BigDecimal limit;

    public static CustomerCardResponse toCustomerCard(CustomerCard customerCard) {
        return new CustomerCardResponse(
                customerCard.getCard().getName(),
                customerCard.getCard().getPaymentGroup().toString(),
                customerCard.getLimit()
        );
    }
}