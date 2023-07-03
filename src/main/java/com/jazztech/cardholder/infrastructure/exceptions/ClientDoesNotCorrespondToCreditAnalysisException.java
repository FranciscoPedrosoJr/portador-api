package com.jazztech.cardholder.infrastructure.exceptions;

public class ClientDoesNotCorrespondToCreditAnalysisException extends RuntimeException {
    public ClientDoesNotCorrespondToCreditAnalysisException(String message) {
        super(message);
    }
}

