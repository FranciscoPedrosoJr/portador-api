package com.example.cardholder.applicationservice.cardholderservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jazztech.cardholder.applicationservice.service.CardHolderService;
import com.jazztech.cardholder.infrastructure.apicreditanalisys.CreditAnalisysApi;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderMapper;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderMapperImpl;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import factory.CardHolderEntityFactory;
import factory.CardHolderRequestFactory;
import factory.CreditAnalisysDtoFactory;
import java.util.Collections;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CreateCardHolderTest {
    @Mock
    private CreditAnalisysApi creditAnalisysApi;
    @Mock
    private CardHolderRepository cardHolderRepository;

    @Spy
    private CardHolderMapper cardHolderMapper = new CardHolderMapperImpl();

    @InjectMocks
    private CardHolderService createCardHolders;

    @Captor
    private ArgumentCaptor<UUID> analisysIdArgumentCaptor;

    @Captor
    private ArgumentCaptor<CardHolderEntity> cardHolderEntityArgumentCaptor;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        analisysIdArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
    }

    @Test
    void shouldMapEntitys() {
        final CardHolderDTORequest cardHolderDTORequest = CardHolderRequestFactory.CardHolderRequest();
        final CardHolderEntity cardHolderEntity = CardHolderEntityFactory.createCardHolderEntity();

        Mockito.when(creditAnalisysApi.getCreditAnalisysById(analisysIdArgumentCaptor.capture())).thenReturn(
                Collections.singletonList(CreditAnalisysDtoFactory.CreditAnalisysDto()));
        Mockito.when(cardHolderRepository.save(cardHolderEntityArgumentCaptor.capture())).thenReturn(cardHolderEntity);

        createCardHolders.createCardHolder(cardHolderDTORequest);
        final CardHolderEntity cardHolderEntityvalue = cardHolderEntityArgumentCaptor.getValue();

        assertEquals(cardHolderDTORequest.creditAnalysisId(), analisysIdArgumentCaptor.getValue());
        assertEquals(cardHolderEntity.getclientid(), cardHolderEntityvalue.getclientid());
        assertEquals(cardHolderEntity.getCardHolderStatus(), cardHolderEntityvalue.getCardHolderStatus());
        assertEquals(cardHolderEntity.getCardHolderLimit(), cardHolderEntityvalue.getCardHolderLimit());
    }
}
