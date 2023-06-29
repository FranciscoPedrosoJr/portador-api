package com.jazztech.cardholder.applicationservice.service;

import com.jazztech.cardholder.applicationservice.domain.entity.CreditCardDomain;
import com.jazztech.cardholder.infrastructure.exceptions.CardHolderNotFoundException;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.infrastructure.repository.util.CreditCardRepository;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CreditCardService {
    private final CardHolderRepository cardHolderRepository;
    private final CreditCardRepository creditCardRepository;

    public CreditCardService(CardHolderRepository cardHolderRepository, CreditCardRepository creditCardRepository) {
        this.cardHolderRepository = cardHolderRepository;
        this.creditCardRepository = creditCardRepository;
    }

    public CreditCardEntity createCreditCard(CreditCardDomain creditCardDomain, UUID cardHolderId) {
        final CardHolderEntity cardHolder = cardHolderRepository.findById(cardHolderId)
                .orElseThrow(() -> new CardHolderNotFoundException("Card holder not found"));

        final CreditCardEntity creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCardNumber(generateCardNumber());
        creditCardEntity.setCvv(generateCvv());
        creditCardEntity.setCreatedAt(LocalDateTime.now());

        creditCardRepository.save(creditCardEntity);

        return creditCardEntity;
    }

    private String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumberBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            cardNumberBuilder.append(digit);
        }
        return cardNumberBuilder.toString();
    }

    private int generateCvv() {
        Random random = new Random();
        return 100 + random.nextInt(900);
    }
}
