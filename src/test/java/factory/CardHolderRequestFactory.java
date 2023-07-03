package factory;

import com.jazztech.cardholder.presentation.dto.CardHolderDTORequest;
import java.util.UUID;

public class CardHolderRequestFactory {

    public static CardHolderDTORequest CardHolderRequest() {
        return new CardHolderDTORequest(
                UUID.fromString("572cc6c8-487b-4b57-b54d-e0b3eb34e196"),
                UUID.fromString("572cc6c8-487b-4b57-b54d-e0b3eb34e196"),
                new CardHolderDTORequest.bankAccountDomain(
                        "0924493-7",
                        "1553",
                        "036"
                )
        );
    }
}
