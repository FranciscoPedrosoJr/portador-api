package factory;

import com.jazztech.cardholder.presentation.dto.CreditCardDTORequest;

public class CreditCardDtoRequestFactory {
    public static CreditCardDTORequest createCreditCardDTORequest() {
        CreditCardDTORequest dtoRequest = new CreditCardDTORequest("",500.00);
        dtoRequest.setCardHolderId("12345678-1234-1234-1234-123456789012");
        return dtoRequest;
    }
}
