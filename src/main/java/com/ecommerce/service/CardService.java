package com.ecommerce.service;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.dto.CardDto;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.Card;

import java.util.List;

public interface CardService {
    List<CardDto> findAll();

    CardDto add(Card address);
    CardDto delete(Long id);
    CardDto findById(Long id);
}
