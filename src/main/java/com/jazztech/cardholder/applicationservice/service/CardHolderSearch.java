package com.jazztech.cardholder.applicationservice.service;

import com.jazztech.cardholder.infrastructure.exceptions.CardHolderNotFoundException;
import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.presentation.dto.CardHolderDTOResponse;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderMapper;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardHolderSearch {
    private final CardHolderRepository cardHolderRepository;
    private final CardHolderMapper mapper;

    public CardHolderSearch(CardHolderRepository cardHolderRepository, CardHolderMapper mapper) {
        this.cardHolderRepository = cardHolderRepository;
        this.mapper = mapper;
    }

    public List<CardHolderDTOResponse> getAllCardHolders() {
        List<CardHolderEntity> cardHolderEntities = cardHolderRepository.findAll();
        return cardHolderEntities.stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }

    public CardHolderDTOResponse getCardHolderById(UUID id) {
        Optional<CardHolderEntity> cardHolderEntity = cardHolderRepository.findById(id);
        if (cardHolderEntity.isPresent()) {
            return mapper.entityToDTO(cardHolderEntity.get());
        } else {
            throw new CardHolderNotFoundException("Card Holder not found");
        }
    }
}
