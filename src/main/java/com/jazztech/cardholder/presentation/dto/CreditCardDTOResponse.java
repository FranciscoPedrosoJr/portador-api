package com.jazztech.cardholder.presentation.dto;

import java.time.LocalDate;
import java.util.UUID;

public class CreditCardDTOResponse {
    private UUID cardId;
    private String cardNumber;
    private int cvv;
    private LocalDate dueDate;

    public CreditCardDTOResponse() {
    }

    public CreditCardDTOResponse(UUID cardId, String cardNumber, int cvv, LocalDate dueDate) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.dueDate = dueDate;
    }

    public UUID getCardId() {
        return cardId;
    }

    public void setCardId(UUID cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
