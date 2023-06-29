package com.jazztech.cardholder.infrastructure.repository.util;

import com.jazztech.cardholder.applicationservice.domain.entity.CardHolderDomain;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import com.jazztech.cardholder.presentation.dto.CardHolderDTOResponse;
import jakarta.validation.Valid;
import java.util.UUID;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CardHolderMapper {
    @BeforeMapping
    default void generateIdAndDate(@MappingTarget CardHolderEntity cardHolderEntity) {
        cardHolderEntity.setCardHolderId(UUID.randomUUID());
        //cardHolderEntity.setcreatedAt(LocalDateTime.now());
    }

    CardHolderEntity domainToEntity(CardHolderDomain cardHolderDomain);

    CardHolderDomain dtoToDomain(@Valid CardHolderDTORequest cardHolderDTORequest);

    @Mapping(source = "cardHolderId", target = "cardHolderId")
    CardHolderDTOResponse entityToDTO(@Valid CardHolderEntity cardHolderEntity);

}
