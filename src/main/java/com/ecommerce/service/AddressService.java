package com.ecommerce.service;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.entity.Address;

import java.util.List;

public interface AddressService {

    List<AddressDto> findAll();
    AddressDto add(Address address);
    AddressDto delete(Long id);
    AddressDto findById(Long id);
}
