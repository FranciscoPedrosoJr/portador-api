package com.jazztech.cardholder.applicationservice.service;

import com.jazztech.cardholder.infrastructure.repository.entity.CardHolderEntity;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderRepository;
import com.jazztech.cardholder.presentation.dto.CardHolderDTOResponse;
import com.jazztech.cardholder.infrastructure.repository.util.CardHolderMapper;
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
}
