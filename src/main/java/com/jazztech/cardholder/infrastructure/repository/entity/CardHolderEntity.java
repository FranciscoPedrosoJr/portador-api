package com.jazztech.cardholder.infrastructure.repository.entity;

import com.jazztech.cardholder.util.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Immutable;

@Table(name = "cardholder")
@Entity
@Immutable
@Getter
@Setter
public class CardHolderEntity {
    private static final Integer ROUND = 2;
    @Id
    @Column(name = "cardholderid")
    UUID cardHolderId;

    UUID clientid;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    StatusEnum cardHolderStatus;

    @Column(name = "creditlimit")
    Double cardHolderLimit;

    @CreationTimestamp
    @Column(name = "createdat")
    LocalDateTime cardHolderCreatedAt;

    public CardHolderEntity() {

    }

    public CardHolderEntity(
            UUID cardHolderId,
            Double cardHolderLimit,
            LocalDateTime cardHolderCreatedAt
    ) {
        this.cardHolderId = cardHolderId;
        this.cardHolderLimit = cardHolderLimit;
        this.cardHolderCreatedAt = cardHolderCreatedAt;
    }

}
