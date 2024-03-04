package com.ecommerce.util;

import com.ecommerce.dto.CardDto;
import com.ecommerce.entity.Card;
import java.util.ArrayList;
import java.util.List;

public class CardDtoConversion {
    public static List<CardDto> convertCardsList (List<Card> cards){
        List<CardDto> cardDtos = new ArrayList<>();
        cards.stream().forEach(card ->
                cardDtos.add(new CardDto(card.getCardNo(),card.getExpireMonth(),
                        card.getExpireYear(),card.getNameOnCard())));
        return cardDtos;
    }

    public static CardDto convertCard(Card card){
        return new CardDto(card.getCardNo(),card.getExpireMonth(),
                card.getExpireYear(),card.getNameOnCard());
    }
}
