package com.jazztech.cardholder.infrastructure.exceptions;

public class CreditAnalisysNotApproved extends RuntimeException {
    public CreditAnalisysNotApproved(String message) {
        super(message);
    }
}

