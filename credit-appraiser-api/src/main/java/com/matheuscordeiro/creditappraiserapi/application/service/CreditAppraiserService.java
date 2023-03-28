package com.matheuscordeiro.creditappraiserapi.application.service;

import com.matheuscordeiro.creditappraiserapi.application.exception.CustomerDataNotFoundException;
import com.matheuscordeiro.creditappraiserapi.domain.CreditIssueRequest;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCredit;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCreditResponse;
import com.matheuscordeiro.creditappraiserapi.domain.RequestCardProtocol;

public interface CreditAppraiserService {
    CustomerCredit retrieveCustomerCredit(String document) throws CustomerDataNotFoundException;

    CustomerCreditResponse createCustomerCredit(String document, Long income) throws CustomerDataNotFoundException;

    RequestCardProtocol requestCard(CreditIssueRequest creditIssueRequest);
}