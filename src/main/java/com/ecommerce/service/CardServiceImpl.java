package com.ecommerce.service;


import com.ecommerce.dto.CardDto;
import com.ecommerce.entity.Card;
import com.ecommerce.exception.CardException;
import com.ecommerce.repository.CardRepository;
import com.ecommerce.util.CardDtoConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CardServiceImpl implements CardService{

    private CardRepository cardRepository;
    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<CardDto> findAll() {
        List<Card> cards = cardRepository.findAll();
        return CardDtoConversion.convertCardsList(cards);
    }

    @Override
    public CardDto add(Card card) {
        Card card1 = cardRepository.save(card);
        return CardDtoConversion.convertCard(card1);
    }

    @Override
    public CardDto findById(Long id) {
        Optional<Card> cardOptional = cardRepository.findById(id);
        if(cardOptional.isPresent()){
            Card card = cardOptional.get();
            return CardDtoConversion.convertCard(card);
        }
        throw new CardException("Card with given id is not exist." + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public CardDto delete(Long id) {
        CardDto cardDto = findById(id);
        cardRepository.deleteById(id);
        return cardDto;
    }
}
