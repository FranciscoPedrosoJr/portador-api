package factory;

import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.util.enums.StatusEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CardHolderEntityFactory {
    public static CardHolderEntity createCardHolderEntity() {
        UUID cardHolderId = UUID.fromString("0a46e1e3-730d-4d83-8274-5b5a8c540e82");
        UUID clientId = UUID.fromString("f3e742cc-42a5-4d73-9f53-862e7c6a72f1");
        Double cardHolderLimit = 5000.00;
        StatusEnum cardHolderStatus = StatusEnum.ACTIVE;
        LocalDateTime cardHolderCreatedAt = LocalDateTime.of(2023, 6, 27, 15, 15);

        return new CardHolderEntity(
                cardHolderId,
                clientId,
                cardHolderLimit,
                cardHolderStatus,
                cardHolderCreatedAt
        );
    }
}
