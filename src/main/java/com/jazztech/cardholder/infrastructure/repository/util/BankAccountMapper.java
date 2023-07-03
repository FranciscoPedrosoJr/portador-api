package com.jazztech.cardholder.infrastructure.repository.util;

import com.jazztech.cardholder.applicationservice.domain.entity.BankAccountDomain;
import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface BankAccountMapper {
    BankAccountDomain fromDomain(CardHolderDTORequest.bankAccountDomain bankAccountRequest);
}
