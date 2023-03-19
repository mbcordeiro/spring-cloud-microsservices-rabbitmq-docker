package com.matheuscordeiro.cardsapi.application.controller;

import com.matheuscordeiro.cardsapi.application.presentation.CardRequest;
import com.matheuscordeiro.cardsapi.application.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
