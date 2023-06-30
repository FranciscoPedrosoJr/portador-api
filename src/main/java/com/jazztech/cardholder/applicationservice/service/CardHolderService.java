package com.jazztech.cardholder.applicationservice.service;

import com.jazztech.cardholder.applicationservice.domain.entity.CardHolderDomain;
import com.jazztech.cardholder.infrastructure.apicreditanalisys.CreditAnalisysApi;
import com.jazztech.cardholder.infrastructure.apicreditanalisys.dto.CreditAnalisysDto;
import com.jazztech.cardholder.infrastructure.exceptions.ClientDoesNotCorrespondToCreditAnalysisException;
import com.jazztech.cardholder.infrastructure.exceptions.ClientWithIDAlreadyExistsException;
import com.jazztech.cardholder.infrastructure.exceptions.CreditAnalisysNotApproved;
import com.jazztech.cardholder.infrastructure.exceptions.CreditAnalisysNotFoundException;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderMapper;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import com.jazztech.cardholder.presentation.dto.CardHolderDTOResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@RequiredArgsConstructor
@Validated
public class CardHolderService {
    private final CreditAnalisysApi creditAnalisysApi;
    private final CardHolderRepository cardHolderRepository;
    private final CardHolderMapper cardHolderMapper;

    @Transactional
    public CardHolderDTOResponse createCardHolder(@Valid CardHolderDTORequest cardHolderDTORequest) {

        final List<CreditAnalisysDto> creditAnalisys = findCreditAnalisysById(cardHolderDTORequest.clientid(), cardHolderDTORequest.creditAnalysisId());

        final CardHolderDomain cardHolderDomain = cardHolderMapper.dtoToDomain(cardHolderDTORequest).toBuilder()
                .build();

        final CardHolderEntity cardHolderEntity = cardHolderMapper.domainToEntity(cardHolderDomain);
        final CardHolderEntity savedCardHolder = cardHolderRepository.save(cardHolderEntity);

        return cardHolderMapper.entityToDTO(savedCardHolder);
    }

    private List<CreditAnalisysDto> findCreditAnalisysById(UUID clientid, UUID analisysId) {
        final List<CreditAnalisysDto> creditAnalisys = creditAnalisysApi.getCreditAnalisysById(clientid);

        if (Objects.isNull(creditAnalisys)) {
            throw new CreditAnalisysNotFoundException("Análise de crédito com ID: %s não encontrada".formatted(analisysId));
        }

        return creditAnalisys;
    }
}
