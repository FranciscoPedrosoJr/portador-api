package com.jazztech.cardholder.presentation.dto;

public class CreditCardDTORequest {
    private String cardHolderId;
    private double limit;

    public CreditCardDTORequest(String cardHolderId, double limit) {
        this.cardHolderId = cardHolderId;
        this.limit = limit;
    }

    public String getCardHolderId() {
        return cardHolderId;
    }

    public void setCardHolderId(String cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }
}
