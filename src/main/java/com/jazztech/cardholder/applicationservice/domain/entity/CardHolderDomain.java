package com.jazztech.cardholder.applicationservice.domain.entity;

import com.jazztech.cardholder.util.enums.StatusEnum;
import java.util.UUID;
import lombok.Builder;

@Builder(toBuilder = true)
public record CardHolderDomain(
        UUID clientid,
        UUID creditAnalysisId,
        StatusEnum cardHolderStatus,
        BankAccountDomain bankAccountDomain
) {
}
