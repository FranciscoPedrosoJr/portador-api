package factory;

import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.util.enums.StatusEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CardHolderEntityFactory {
    public static CardHolderEntity CardHolderEntity() {
        return new CardHolderEntity(
                UUID.fromString("0a46e1e3-730d-4d83-8274-5b5a8c540e82"),
                Double.valueOf(5000.00),
                LocalDateTime.of(2023,6,27,15,15)
        );
    }
}
