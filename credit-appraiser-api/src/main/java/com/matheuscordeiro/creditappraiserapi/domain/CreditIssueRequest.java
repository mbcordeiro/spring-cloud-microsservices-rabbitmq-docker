package com.matheuscordeiro.creditappraiserapi.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditIssueRequest {
    private Long id;
    private String document;
    private String address;
    private BigDecimal limit;
}