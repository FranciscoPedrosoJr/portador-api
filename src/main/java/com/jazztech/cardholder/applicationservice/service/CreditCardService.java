package com.jazztech.cardholder.applicationservice.service;

import com.jazztech.cardholder.applicationservice.domain.entity.CreditCardDomain;
import com.jazztech.cardholder.infrastructure.exceptions.CardHolderNotFoundException;
import com.jazztech.cardholder.infrastructure.exceptions.CreditCardNotFoundException;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.infrastructure.repository.util.CreditCardRepository;
import java.time.LocalDate;
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
        creditCardEntity.setCardId(creditCardDomain.cardId());
        creditCardEntity.setCardNumber(generateCardNumber());
        creditCardEntity.setCvv(generateCvv());
        creditCardEntity.setCreatedAt(LocalDateTime.now());
        creditCardEntity.setCardHolderId(cardHolderId);
        creditCardEntity.setDueDate(LocalDate.now());

        creditCardRepository.save(creditCardEntity);

        return creditCardEntity;
    }

    private String generateCardNumber() {
        final Random random = new Random();
        final Integer CardMax = 16;
        final StringBuilder cardNumberBuilder = new StringBuilder();
        for (int i = 0; i < CardMax; i++) {
            final int digit = random.nextInt(10);
            cardNumberBuilder.append(digit);
        }
        return cardNumberBuilder.toString();
    }

    private int generateCvv() {
        final Random random = new Random();
        final Integer CvvRandom = 100;
        final Integer CvvBound = 900;
        return CvvRandom + random.nextInt(CvvBound);
    }

    public double updateCardHolderLimit(UUID cardHolderId, UUID cardId, Double Limit) {
        final CardHolderEntity cardHolder = cardHolderRepository.findById(cardHolderId)
                .orElseThrow(() -> new CardHolderNotFoundException("Card holder not found"));

        final CreditCardEntity creditCard = creditCardRepository.findByCardIdAndCardHolderId(cardId, cardHolderId)
                .orElseThrow(() -> new CreditCardNotFoundException("Credit card not found"));


        cardHolder.setCardHolderLimit(Limit);
        cardHolderRepository.save(cardHolder);
        return Limit;
    }
}
