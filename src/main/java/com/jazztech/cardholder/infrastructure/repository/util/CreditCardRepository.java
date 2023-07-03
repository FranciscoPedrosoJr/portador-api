package com.jazztech.cardholder.infrastructure.repository.util;

import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, UUID> {
    List<CreditCardEntity> findByCardHolderId(UUID cardHolderId);

    Optional<CreditCardEntity> findByCardIdAndCardHolderId(UUID cardId, UUID cardHolderId);
}
