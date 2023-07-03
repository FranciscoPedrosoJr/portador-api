package com.jazztech.cardholder.infrastructure.exceptions;

public class CardHolderNotFoundException extends RuntimeException {
    public CardHolderNotFoundException(String message) {
        super(message);
    }

}
