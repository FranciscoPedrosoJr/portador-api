package com.jazztech.cardholder.infrastructure.repository.util;

import com.jazztech.cardholder.applicationservice.domain.entity.BankAccountDomain;
import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-27T11:01:35-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public BankAccountDomain fromDomain(CardHolderDTORequest.bankAccountDomain bankAccountRequest) {

        String account = null;
        String agency = null;
        String bankCode = null;
        if ( bankAccountRequest != null ) {
            account = bankAccountRequest.account();
            agency = bankAccountRequest.agency();
            bankCode = bankAccountRequest.bankCode();
        }

        BankAccountDomain bankAccountDomain = new BankAccountDomain( account, agency, bankCode );

        if ( bankAccountRequest != null ) {
        }

        return bankAccountDomain;
    }
}
