package com.jazztech.cardholder.applicationservice.service;

import com.jazztech.cardholder.infrastructure.exceptions.CardHolderNotFoundException;
import com.jazztech.cardholder.infrastructure.exceptions.CreditCardNotFoundException;
import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.infrastructure.repository.util.CreditCardRepository;
import com.jazztech.cardholder.presentation.dto.CreditCardDTOResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class CreditCardSearch {
    private final CardHolderRepository cardHolderRepository;
    private final CreditCardRepository creditCardRepository;

    public CreditCardSearch(CardHolderRepository cardHolderRepository, CreditCardRepository creditCardRepository) {
        this.cardHolderRepository = cardHolderRepository;
        this.creditCardRepository = creditCardRepository;
    }

    public List<CreditCardDTOResponse> getAllCreditCards(UUID cardHolderId) {
        cardHolderRepository.findById(cardHolderId)
                .orElseThrow(() -> new CardHolderNotFoundException("Card holder not found"));

        final List<CreditCardEntity> creditCards = creditCardRepository.findByCardHolderId(cardHolderId);

        return creditCards.stream()
                .map(this::mapToCreditCardDTOResponse)
                .collect(Collectors.toList());
    }

    public CreditCardDTOResponse getCreditCard(UUID cardHolderId, UUID cardId) {
        cardHolderRepository.findById(cardHolderId)
                .orElseThrow(() -> new CardHolderNotFoundException("Card holder not found"));

        final Optional<CreditCardEntity> creditCard = creditCardRepository.findByCardIdAndCardHolderId(cardId, cardHolderId);

        if (creditCard.isPresent()) {
            return mapToCreditCardDTOResponse(creditCard.get());
        } else {
            throw new CreditCardNotFoundException("Credit card not found");
        }
    }

    private CreditCardDTOResponse mapToCreditCardDTOResponse(CreditCardEntity creditCardEntity) {
        return new CreditCardDTOResponse(
                creditCardEntity.getCardId(),
                creditCardEntity.getCardNumber(),
                creditCardEntity.getCvv(),
                creditCardEntity.getDueDate()
        );
    }
}
