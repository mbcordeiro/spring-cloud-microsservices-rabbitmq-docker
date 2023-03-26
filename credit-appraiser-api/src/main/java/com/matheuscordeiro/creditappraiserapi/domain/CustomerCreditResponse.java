package com.matheuscordeiro.creditappraiserapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerCreditResponse {
    List<ApprovedCard> approvedCards;
}