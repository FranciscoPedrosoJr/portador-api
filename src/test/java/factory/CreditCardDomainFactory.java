package factory;

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CreditCardDomainFactory {
    public static CreditCardDomain createCreditCardDomain() {
        UUID cardId = UUID.randomUUID();
        String cardNumber = "1234567890123456";
        Integer cvv = 123;
        LocalDate dueDate = LocalDate.now().plusMonths(1);
        LocalDateTime createdAt = LocalDateTime.now();
        LocalDateTime updatedAt = LocalDateTime.now().plusMinutes(30);
        UUID cardHolderId = UUID.randomUUID();

        return new CreditCardDomain(
                cardId,
                cardNumber,
                cvv,
                dueDate,
                createdAt,
                updatedAt,
                cardHolderId
        );
    }

}
