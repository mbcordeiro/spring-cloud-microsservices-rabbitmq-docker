package com.matheuscordeiro.creditappraiserapi.application.controller;

import com.matheuscordeiro.creditappraiserapi.domain.CustomerCredit;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("credit-appraiser")
public class CreditAppraiserController {
    @GetMapping
    public String status() {
        return "ok";
    }

    @GetMapping(value = "customer-credit", params = "document")
    public ResponseEntity<CustomerCredit> getCustomerClient(@RequestParam("document") String document) {
        return null;
    }
}