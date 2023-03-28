package com.matheuscordeiro.creditappraiserapi.infa.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.matheuscordeiro.creditappraiserapi.domain.CreditIssueRequest;

public interface CreditIssuePublisher {
    void requestCard(CreditIssueRequest creditIssueRequest) throws JsonProcessingException;
}