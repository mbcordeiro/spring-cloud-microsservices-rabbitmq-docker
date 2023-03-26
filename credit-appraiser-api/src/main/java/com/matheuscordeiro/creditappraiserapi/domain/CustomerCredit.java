package com.matheuscordeiro.creditappraiserapi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCredit {
    private CustomerData customerData;
    private List<CustomerCard> customerCards;
}