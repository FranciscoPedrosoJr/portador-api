package com.jazztech.cardholder.infrastructure.repository.util;

import com.jazztech.cardholder.infrastructure.repository.entity.CreditCardEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends JpaRepository<CreditCardEntity, UUID> {
}
