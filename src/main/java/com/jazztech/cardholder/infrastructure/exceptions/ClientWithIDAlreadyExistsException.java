package com.jazztech.cardholder.infrastructure.exceptions;

public class ClientWithIDAlreadyExistsException extends RuntimeException {
    public ClientWithIDAlreadyExistsException(String message) {
        super(message);
    }
}

