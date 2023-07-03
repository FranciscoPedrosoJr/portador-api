package com.jazztech.cardholder.infrastructure.repository.util;

import com.jazztech.cardholder.applicationservice.domain.entity.CreditCardDomain;
import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import com.jazztech.cardholder.presentation.dto.CreditCardDTORequest;
import com.jazztech.cardholder.presentation.dto.CreditCardDTOResponse;
import java.util.UUID;

public interface CreditCardMapper {
    static CreditCardEntity toEntity(CreditCardDomain creditCardDomain) {
        final CreditCardEntity creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCardId(creditCardDomain.cardId());
        creditCardEntity.setCardNumber(creditCardDomain.cardNumber());
        creditCardEntity.setCvv(creditCardDomain.cvv());
        creditCardEntity.setDueDate(creditCardDomain.dueDate());
        creditCardEntity.setCreatedAt(creditCardDomain.createdAt());
        creditCardEntity.setUpdatedAt(creditCardDomain.updatedAt());
        return creditCardEntity;
    }

    static CreditCardDomain toDomain(CreditCardEntity creditCardEntity) {
        return new CreditCardDomain(
                creditCardEntity.getCardId(),
                creditCardEntity.getCardNumber(),
                creditCardEntity.getCvv(),
                creditCardEntity.getDueDate(),
                creditCardEntity.getCreatedAt(),
                creditCardEntity.getUpdatedAt(),
                creditCardEntity.getCardHolderId()
        );
    }

    static CreditCardDTOResponse toDTOResponse(CreditCardDomain creditCardDomain) {
        return new CreditCardDTOResponse(
                creditCardDomain.cardId(),
                creditCardDomain.cardNumber(),
                creditCardDomain.cvv(),
                creditCardDomain.dueDate()
        );
    }

    static CreditCardDomain toDomain(CreditCardDTORequest dtoRequest) {
        return new CreditCardDomain(
                null,
                null,
                null,
                null,
                null,
                null,
                UUID.fromString(dtoRequest.getCardHolderId())
        );
    }
}
