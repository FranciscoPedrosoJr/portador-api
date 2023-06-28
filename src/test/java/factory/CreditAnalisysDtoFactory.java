package factory;

import com.jazztech.cardholder.infrastructure.apicreditanalisys.dto.CreditAnalisysDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CreditAnalisysDtoFactory {
    public static CreditAnalisysDto CreditAnalisysDto(){
        return new CreditAnalisysDto(
                UUID.fromString("29b252af-f5b0-4a9e-9c63-94ca8f3d01c7"),
                true,
                BigDecimal.valueOf(5000),
                BigDecimal.valueOf(3500),
                BigDecimal.valueOf(3400),
                UUID.fromString("5f10700b-2b2e-4758-9f60-ea818790ca27"),
                LocalDateTime.of(2023,6,27,15,15)
        );
    }
}

