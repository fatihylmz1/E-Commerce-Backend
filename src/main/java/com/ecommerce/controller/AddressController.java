package com.ecommerce.controller;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.entity.Address;
import com.ecommerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
@CrossOrigin("*")
public class AddressController {
    private AddressService addressService;
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<AddressDto> showAll(){
        return addressService.findAll();
    }

    @GetMapping("/address/{id}")
    public AddressDto showById(@PathVariable Long id){
        return addressService.findById(id);
    }

    @DeleteMapping("/address/{id}")
    public AddressDto delete(@PathVariable Long id){
        return addressService.delete(id);
    }

    @PostMapping("/address")
    public AddressDto addAddress(@RequestBody Address address){
        return addressService.add(address);
    }
}
