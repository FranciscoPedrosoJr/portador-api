package com.jazztech.cardholder.presentation.controller;

import com.jazztech.cardholder.applicationservice.service.CardHolderSearch;
import com.jazztech.cardholder.applicationservice.service.CardHolderService;
import com.jazztech.cardholder.infrastructure.exceptions.CardHolderAlreadyExistsException;
import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import com.jazztech.cardholder.presentation.dto.CardHolderDTOResponse;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1.0/cardholder")
@Validated
public class CardHolderController {
    private final CardHolderService cardHolderService;
    private final CardHolderSearch cardHolderSearch;

    @PostMapping("/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public CardHolderDTOResponse createCardHolder(@RequestBody @Valid CardHolderDTORequest cardHolderDTORequest) throws
            CardHolderAlreadyExistsException {
        return cardHolderService.createCardHolder(cardHolderDTORequest);
    }

    @GetMapping("/all")
    public List<CardHolderDTOResponse> getAllCardHolders() {
        return cardHolderSearch.getAllCardHolders();
    }

}
