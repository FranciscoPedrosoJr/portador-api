package com.example.cardholder.applicationservice.cardholderservice;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.jazztech.cardholder.applicationservice.domain.entity.CreditCardDomain;
import com.jazztech.cardholder.applicationservice.service.CreditCardService;
import com.jazztech.cardholder.infrastructure.exceptions.CardHolderNotFoundException;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.infrastructure.repository.util.CreditCardRepository;
import factory.CreditCardDomainFactory;
import factory.CreditCardEntityFactory;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CreateCreditCardTest {
    @Mock
    private CardHolderRepository cardHolderRepository;

    @Mock
    private CreditCardRepository creditCardRepository;

    @InjectMocks
    private CreditCardService creditCardService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCreditCard() {
        final UUID cardHolderId = UUID.randomUUID();
        final CreditCardDomain creditCardDomain = CreditCardDomainFactory.createCreditCardDomain();
        final CreditCardEntity creditCardEntity = CreditCardEntityFactory.createCreditCardEntity();

        CardHolderEntity cardHolderEntity = new CardHolderEntity();
        when(cardHolderRepository.findById(cardHolderId)).thenReturn(Optional.of(cardHolderEntity));

        when(creditCardRepository.save(Mockito.any(CreditCardEntity.class))).thenReturn(creditCardEntity);

        CreditCardEntity result = creditCardService.createCreditCard(creditCardDomain, cardHolderId);

        assertNotNull(result);
        assertEquals(creditCardDomain.cardNumber(), result.getCardNumber());
        assertEquals(creditCardDomain.cvv(), result.getCvv());
        assertNotNull(result.getCreatedAt());

        verify(creditCardRepository, times(1)).save(result);
    }

    @Test
    public void testCreateCreditCard_InvalidCardHolderId() {
        UUID invalidCardHolderId = UUID.randomUUID();
        CreditCardDomain creditCardDomain = CreditCardDomainFactory.createCreditCardDomain();

        when(cardHolderRepository.findById(invalidCardHolderId)).thenReturn(Optional.empty());

        assertThrows(CardHolderNotFoundException.class, () -> {
            creditCardService.createCreditCard(creditCardDomain, invalidCardHolderId);
        });

        verify(creditCardRepository, never()).save(Mockito.any(CreditCardEntity.class));
    }
}
