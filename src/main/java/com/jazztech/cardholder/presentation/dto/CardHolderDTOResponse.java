package com.jazztech.cardholder.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jazztech.cardholder.util.enums.StatusEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CardHolderDTOResponse(
        UUID cardHolderId,
        StatusEnum status,
        BigDecimal limit,
        LocalDateTime createdAt
){
}
