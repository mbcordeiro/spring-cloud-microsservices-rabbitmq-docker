package com.matheuscordeiro.creditappraiserapi.domain;

import lombok.Data;

@Data
public class CustomerCreditData {
    private String document;
    private Long income;
}