package com.jazztech.cardholder.applicationservice.domain.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
public record CreditCardDomain(
        UUID cardId,
        String cardNumber,
        Integer cvv,
        LocalDate dueDate,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        UUID cardHolderId
){
    public CreditCardDomain(
            UUID cardId,
            String cardNumber,
            Integer cvv,
            LocalDate dueDate,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            UUID cardHolderId
    ) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.cardHolderId = cardHolderId;
    }
}
