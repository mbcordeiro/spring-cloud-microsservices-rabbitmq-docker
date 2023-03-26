package com.matheuscordeiro.creditappraiserapi.application.controller;

import com.matheuscordeiro.creditappraiserapi.application.service.CreditAppraiserService;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCredit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<CustomerCredit> getCustomerClient(@RequestParam("document") String document) {
        final var customerCredit = creditAppraiserService.retrieveCustomerCredit(document);
        return ResponseEntity.ok(customerCredit);
    }
}