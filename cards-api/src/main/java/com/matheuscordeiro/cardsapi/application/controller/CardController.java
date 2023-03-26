package com.matheuscordeiro.cardsapi.application.controller;

import com.matheuscordeiro.cardsapi.application.presentation.CustomerCardResponse;
import com.matheuscordeiro.cardsapi.application.presentation.CardRequest;
import com.matheuscordeiro.cardsapi.application.service.CardService;
import com.matheuscordeiro.cardsapi.application.service.CustomerCardService;
import com.matheuscordeiro.cardsapi.domain.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    private final CustomerCardService customerCardService;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Void> register(@RequestBody CardRequest cardRequest) {
        final var card = cardRequest.toCard();
        cardService.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardByIncome(@RequestParam("income") Long income) {
        final var cardList = cardService.findCardsByIncomeLessThanEqual(BigDecimal.valueOf(income));
        return ResponseEntity.ok(cardList);
    }

    @GetMapping(params = "document")
    public ResponseEntity<List<CustomerCardResponse>> getCardByCustomer(@RequestParam("document") String document) {
        final var customerCardList = customerCardService.findListCardByDocument(document);
        final var customerCardResponseList = customerCardList.stream()
                .map(CustomerCardResponse::toCustomerCard).collect(Collectors.toList());
        return ResponseEntity.ok(customerCardResponseList);
    }
}