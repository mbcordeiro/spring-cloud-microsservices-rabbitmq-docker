package com.matheuscordeiro.cardsapi.application.controller;

import com.matheuscordeiro.cardsapi.application.presentation.CardRequest;
import com.matheuscordeiro.cardsapi.application.service.CardService;
import com.matheuscordeiro.cardsapi.domain.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public String status(){
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
}
