package com.jazztech.cardholder.presentation.controller;

import com.jazztech.cardholder.applicationservice.domain.entity.CreditCardDomain;
import com.jazztech.cardholder.applicationservice.service.CardHolderSearch;
import com.jazztech.cardholder.applicationservice.service.CardHolderService;
import com.jazztech.cardholder.applicationservice.service.CreditCardSearch;
import com.jazztech.cardholder.applicationservice.service.CreditCardService;
import com.jazztech.cardholder.infrastructure.exceptions.CardHolderAlreadyExistsException;
import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CreditCardMapper;
import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import com.jazztech.cardholder.presentation.dto.CardHolderDTOResponse;
import com.jazztech.cardholder.presentation.dto.CreditCardDTORequest;
import com.jazztech.cardholder.presentation.dto.CreditCardDTOResponse;
import com.jazztech.cardholder.presentation.dto.LimitUpdateDTORequest;
import com.jazztech.cardholder.presentation.dto.LimitUpdateDTOResponse;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private final CreditCardService creditCardService;
    private final CreditCardSearch creditCardSearch;

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

    @GetMapping("/{id}")
    public CardHolderDTOResponse getCardHolderById(@PathVariable UUID id) {
        return cardHolderSearch.getCardHolderById(id);
    }

    @PostMapping("/{cardHolderId}/creditcard")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCardDTOResponse createCreditCard(@PathVariable String cardHolderId, @RequestBody @Valid CreditCardDTORequest creditCardDTORequest) {
        final CreditCardDomain creditCardDomain = CreditCardMapper.toDomain(creditCardDTORequest);

        final CreditCardEntity createdCreditCard = creditCardService.createCreditCard(creditCardDomain, UUID.fromString(cardHolderId));

        final CreditCardDomain createdCreditCardDomain = CreditCardMapper.toDomain(createdCreditCard);
        final CreditCardDTOResponse responseDTO = CreditCardMapper.toDTOResponse(createdCreditCardDomain);

        return responseDTO;
    }

    @GetMapping("/{cardHolderId}/creditcards")
    public ResponseEntity<List<CreditCardDTOResponse>> getAllCreditCards(@PathVariable UUID cardHolderId) {
        final List<CreditCardDTOResponse> creditCards = creditCardSearch.getAllCreditCards(cardHolderId);
        return ResponseEntity.ok(creditCards);
    }

    @GetMapping("/{cardHolderId}/creditcards/{cardId}")
    public ResponseEntity<CreditCardDTOResponse> getCreditCard(
            @PathVariable UUID cardHolderId,
            @PathVariable UUID cardId) {
        final CreditCardDTOResponse creditCard = creditCardSearch.getCreditCard(cardHolderId, cardId);
        return ResponseEntity.ok(creditCard);
    }

    @PatchMapping("/{cardHolderId}/cards/{cardId}")
    public ResponseEntity<LimitUpdateDTOResponse> updateCardHolderLimit(
            @PathVariable UUID cardHolderId,
            @PathVariable UUID cardId,
            @RequestBody LimitUpdateDTORequest limitUpdateDTO) {

        double updatedLimit = creditCardService.updateCardHolderLimit(cardHolderId, cardId, limitUpdateDTO.Limit());

        LimitUpdateDTOResponse response = new LimitUpdateDTOResponse(cardId.toString(), updatedLimit);

        return ResponseEntity.ok(response);
    }
}
