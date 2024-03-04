package com.ecommerce.controller;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.dto.CardDto;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.Card;
import com.ecommerce.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
@CrossOrigin("*")
public class CardController {

    private CardService cardService;
    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/card")
    public List<CardDto> showAll(){
        return cardService.findAll();
    }

    @GetMapping("/card/{id}")
    public CardDto showById(@PathVariable Long id){
        return cardService.findById(id);
    }

    @DeleteMapping("/card/{id}")
    public CardDto delete(@PathVariable Long id){
        return cardService.delete(id);
    }

    @PostMapping("/card")
    public CardDto addCard(@RequestBody Card card){
        return cardService.add(card);
    }

}
