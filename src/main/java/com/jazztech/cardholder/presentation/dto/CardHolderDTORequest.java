package com.jazztech.cardholder.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CardHolderDTORequest(
        UUID clientid,
        UUID creditAnalysisId,
        CardHolderDTORequest.bankAccountDomain bankAccountDomain
) {

    public CardHolderDTORequest(
            UUID clientid,
            UUID creditAnalysisId,
            CardHolderDTORequest.bankAccountDomain bankAccountDomain

    ) {

        this.clientid = clientid;
        this.creditAnalysisId = creditAnalysisId;
        this.bankAccountDomain = bankAccountDomain;

    }

    public record bankAccountDomain(
            String account,
            String agency,
            String bankCode
    ) {

        public bankAccountDomain(
                String account,
                String agency,
                String bankCode
        ) {

            this.account = account;
            this.agency = agency;
            this.bankCode = bankCode;
        }
    }
}
