package com.matheuscordeiro.creditappraiserapi.application.service.impl;

import com.matheuscordeiro.creditappraiserapi.application.service.CreditAppraiserService;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCredit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditAppraiserServiceImpl implements CreditAppraiserService {
    @Override
    public CustomerCredit retrieveCustomerCredit(String document) {
        return null;
    }
}