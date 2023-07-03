package com.jazztech.cardholder.presentation.dto;

public class LimitUpdateDTOResponse {
    private String cardId;
    private double updatedLimit;

    public LimitUpdateDTOResponse() {
    }

    public LimitUpdateDTOResponse(String cardId, double updatedLimit) {
        this.cardId = cardId;
        this.updatedLimit = updatedLimit;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getUpdatedLimit() {
        return updatedLimit;
    }

    public void setUpdatedLimit(double updatedLimit) {
        this.updatedLimit = updatedLimit;
    }
}

