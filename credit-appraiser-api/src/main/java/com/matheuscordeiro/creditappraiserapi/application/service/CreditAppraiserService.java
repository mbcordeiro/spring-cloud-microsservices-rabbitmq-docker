package com.matheuscordeiro.creditappraiserapi.application.service;

import com.matheuscordeiro.creditappraiserapi.domain.CustomerCredit;

public interface CreditAppraiserService {
    CustomerCredit retrieveCustomerCredit(String document);
}