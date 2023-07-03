package com.jazztech.cardholder.infrastructure.repository.util;

import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardHolderRepository extends JpaRepository<CardHolderEntity, UUID> {
    <S extends CardHolderEntity> S save(S entity);

}
