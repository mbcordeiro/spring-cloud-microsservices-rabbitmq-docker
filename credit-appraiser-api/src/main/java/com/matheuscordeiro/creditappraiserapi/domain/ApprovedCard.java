package com.matheuscordeiro.creditappraiserapi.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ApprovedCard {
    private String card;
    private String paymentGroup;
    private BigDecimal limit;
}