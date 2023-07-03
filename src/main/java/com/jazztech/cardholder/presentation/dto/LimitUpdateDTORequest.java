package com.jazztech.cardholder.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record LimitUpdateDTORequest(
        Double Limit
){

}
