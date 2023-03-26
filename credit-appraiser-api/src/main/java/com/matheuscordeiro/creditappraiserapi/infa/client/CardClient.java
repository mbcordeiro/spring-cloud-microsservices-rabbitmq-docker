package com.matheuscordeiro.creditappraiserapi.infa.client;

import com.matheuscordeiro.creditappraiserapi.domain.Card;
import com.matheuscordeiro.creditappraiserapi.domain.CustomerCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cards-api", path = "/credits")
public interface CardClient {
    @GetMapping(params = "document")
    ResponseEntity<List<CustomerCard>> getCardByCustomer(@RequestParam("document") String document);

    @GetMapping(params = "income")
    ResponseEntity<List<Card>> getCardByIncome(@RequestParam("income") Long income);
}