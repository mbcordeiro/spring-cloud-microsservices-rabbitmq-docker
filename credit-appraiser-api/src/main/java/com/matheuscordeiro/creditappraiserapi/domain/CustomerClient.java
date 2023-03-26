package com.matheuscordeiro.creditappraiserapi.domain;

import lombok.Data;

import java.util.List;

@Data
public class CustomerClient {
    private CustomerData customerData;
    private List<CustomerCard> customerCards;
}