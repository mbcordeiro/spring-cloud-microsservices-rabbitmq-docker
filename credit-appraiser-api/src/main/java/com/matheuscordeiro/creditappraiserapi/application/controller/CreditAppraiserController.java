package com.matheuscordeiro.creditappraiserapi.application.controller;

import com.matheuscordeiro.creditappraiserapi.application.exception.CustomerDataNotFoundException;
import com.matheuscordeiro.creditappraiserapi.application.service.CreditAppraiserService;
import com.matheuscordeiro.creditappraiserapi.domain.CreditIssueRequest;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCredit;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCreditData;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCreditResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("credit-appraiser")
@RequiredArgsConstructor
public class CreditAppraiserController {
    private final CreditAppraiserService creditAppraiserService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping(value = "customer-credit", params = "document")
    public ResponseEntity<CustomerCredit> getCustomerClient(@RequestParam("document") String document) throws CustomerDataNotFoundException {
        try {
            final var customerCredit = creditAppraiserService.retrieveCustomerCredit(document);
            return ResponseEntity.ok(customerCredit);
        } catch (CustomerDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CustomerCreditResponse> createCustomerCredit(@RequestBody CustomerCreditData customerCreditData) {
        try {
            final var customerCreditResponse = creditAppraiserService.createCustomerCredit(customerCreditData.getDocument(), customerCreditData.getIncome());
            return ResponseEntity.ok(customerCreditResponse);
        } catch (CustomerDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("requests-card")
    public ResponseEntity requestCard(@RequestBody CreditIssueRequest creditIssueRequest) {
        try {
            final var requestCardProtocol = creditAppraiserService.requestCard(creditIssueRequest);
            return ResponseEntity.ok(requestCardProtocol);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}