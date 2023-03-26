package com.matheuscordeiro.creditappraiserapi.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CustomerCard {
    private String name;
    private String paymentGroup;
    private BigDecimal limit;
}