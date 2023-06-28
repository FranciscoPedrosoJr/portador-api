package com.jazztech.cardholder.applicationservice.domain.entity;

public record BankAccountDomain(
        String account,
        String agency,
        String bankCode
){
}
