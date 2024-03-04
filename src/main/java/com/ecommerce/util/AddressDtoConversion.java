package com.ecommerce.util;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.dto.CategoryResponse;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.Categories;

import java.util.ArrayList;
import java.util.List;

public class AddressDtoConversion {

    public static List<AddressDto> convertAddressList (List<Address> address){
        List<AddressDto> addressDtos = new ArrayList<>();
        address.stream().forEach(address1 ->
                addressDtos.add(new AddressDto(address1.getTitle(),address1.getName(),
                        address1.getSurname(),address1.getPhone(),address1.getCity(), address1.getDistrict(), address1.getNeigborhood(),
                        address1.getAddress())));
        return addressDtos;
    }

    public static AddressDto convertAddress(Address address){
        return new AddressDto(address.getTitle(),address.getName(),
                address.getSurname(),address.getPhone(),address.getCity(), address.getDistrict(), address.getNeigborhood(),
                address.getAddress());
    }
}
