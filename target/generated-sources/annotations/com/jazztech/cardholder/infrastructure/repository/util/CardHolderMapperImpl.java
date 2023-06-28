package com.jazztech.cardholder.infrastructure.repository.util;

import com.jazztech.cardholder.applicationservice.domain.entity.BankAccountDomain;
import com.jazztech.cardholder.applicationservice.domain.entity.CardHolderDomain;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import com.jazztech.cardholder.presentation.dto.CardHolderDTOResponse;
import com.jazztech.cardholder.util.enums.StatusEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-27T11:01:35-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
@Component
public class CardHolderMapperImpl implements CardHolderMapper {

    @Override
    public CardHolderEntity domainToEntity(CardHolderDomain cardHolderDomain) {
        if ( cardHolderDomain == null ) {
            return null;
        }

        CardHolderEntity cardHolderEntity = new CardHolderEntity();

        generateIdAndDate( cardHolderEntity );

        cardHolderEntity.setClientid( cardHolderDomain.clientid() );
        cardHolderEntity.setCardHolderStatus( cardHolderDomain.cardHolderStatus() );

        return cardHolderEntity;
    }

    @Override
    public CardHolderDomain dtoToDomain(CardHolderDTORequest cardHolderDTORequest) {
        if ( cardHolderDTORequest == null ) {
            return null;
        }

        CardHolderDomain.CardHolderDomainBuilder cardHolderDomain = CardHolderDomain.builder();

        cardHolderDomain.clientid( cardHolderDTORequest.clientid() );
        cardHolderDomain.creditAnalysisId( cardHolderDTORequest.creditAnalysisId() );
        cardHolderDomain.bankAccountDomain( bankAccountDomainToBankAccountDomain( cardHolderDTORequest.bankAccountDomain() ) );

        return cardHolderDomain.build();
    }

    @Override
    public CardHolderDTOResponse entityToDTO(CardHolderEntity cardHolderEntity) {
        if ( cardHolderEntity == null ) {
            return null;
        }

        UUID cardHolderId = null;

        cardHolderId = cardHolderEntity.getCardHolderId();

        StatusEnum status = null;
        BigDecimal limit = null;
        LocalDateTime createdAt = null;

        CardHolderDTOResponse cardHolderDTOResponse = new CardHolderDTOResponse( cardHolderId, status, limit, createdAt );

        return cardHolderDTOResponse;
    }

    protected BankAccountDomain bankAccountDomainToBankAccountDomain(CardHolderDTORequest.bankAccountDomain bankAccountDomain) {
        if ( bankAccountDomain == null ) {
            return null;
        }

        String account = null;
        String agency = null;
        String bankCode = null;

        account = bankAccountDomain.account();
        agency = bankAccountDomain.agency();
        bankCode = bankAccountDomain.bankCode();

        BankAccountDomain bankAccountDomain1 = new BankAccountDomain( account, agency, bankCode );

        return bankAccountDomain1;
    }
}
