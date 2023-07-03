package com.jazztech.cardholder.applicationservice.service;

import com.jazztech.cardholder.infrastructure.exceptions.CardHolderNotFoundException;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderMapper;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.presentation.dto.CardHolderDTOResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


@Service
public class CardHolderSearch {
    private final CardHolderRepository cardHolderRepository;
    private final CardHolderMapper mapper;

    public CardHolderSearch(CardHolderRepository cardHolderRepository, CardHolderMapper mapper) {
        this.cardHolderRepository = cardHolderRepository;
        this.mapper = mapper;
    }

    public List<CardHolderDTOResponse> getAllCardHolders() {
        final List<CardHolderEntity> cardHolderEntities = cardHolderRepository.findAll();
        return cardHolderEntities.stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }

    public CardHolderDTOResponse getCardHolderById(UUID id) {
        final Optional<CardHolderEntity> cardHolderEntity = cardHolderRepository.findById(id);
        if (cardHolderEntity.isPresent()) {
            return mapper.entityToDTO(cardHolderEntity.get());
        } else {
            throw new CardHolderNotFoundException("Card Holder not found");
        }
    }
}
