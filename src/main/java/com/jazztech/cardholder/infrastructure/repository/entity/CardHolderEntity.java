package com.jazztech.cardholder.infrastructure.repository.entity;

import com.jazztech.cardholder.util.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Column(name = "clientid")
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
            UUID clientid,
            Double cardHolderLimit,
            StatusEnum cardHolderStatus,
            LocalDateTime cardHolderCreatedAt
    ) {
        this.cardHolderId = cardHolderId;
        this.clientid = clientid;
        this.cardHolderLimit = cardHolderLimit;
        this.cardHolderStatus = cardHolderStatus;
        this.cardHolderCreatedAt = cardHolderCreatedAt;
    }

    public void setcardHolderCreatedAt(LocalDateTime now) {
        this.cardHolderCreatedAt = cardHolderCreatedAt;
    }

    public UUID getclientid() {
        return clientid;
    }
    public void setclientid(UUID clientid) {
        this.clientid = clientid;
    }

}
