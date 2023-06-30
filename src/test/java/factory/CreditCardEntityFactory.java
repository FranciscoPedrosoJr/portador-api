package factory;

import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import java.time.LocalDateTime;

public class CreditCardEntityFactory {
    public static CreditCardEntity createCreditCardEntity() {
        CreditCardEntity creditCardEntity = new CreditCardEntity();
        creditCardEntity.setCardNumber("1234567890123456");
        creditCardEntity.setCvv(123);
        creditCardEntity.setCreatedAt(LocalDateTime.now());
        return creditCardEntity;
    }

}
