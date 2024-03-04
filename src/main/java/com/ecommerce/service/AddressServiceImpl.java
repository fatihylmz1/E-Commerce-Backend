package com.ecommerce.service;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.entity.Address;
import com.ecommerce.exception.AddressException;
import com.ecommerce.repository.AddressRepository;
import com.ecommerce.util.AddressDtoConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;
    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressDto> findAll() {
        List<Address> addresses = addressRepository.findAll();
        return AddressDtoConversion.convertAddressList(addresses);
    }

    @Override
    public AddressDto add(Address address) {
        Address address1 = addressRepository.save(address);
        return AddressDtoConversion.convertAddress(address1);
    }


    @Override
    public AddressDto findById(Long id) {
        Optional<Address> addressOptional = addressRepository.findById(id);
        if(addressOptional.isPresent()){
            Address address = addressOptional.get();
            return AddressDtoConversion.convertAddress(address);
        }
        throw new AddressException("Address with given id is not exist." + id , HttpStatus.NOT_FOUND);
    }
    @Override
    public AddressDto delete(Long id) {
        AddressDto address = findById(id);
        addressRepository.deleteById(id);
        return address;
    }
}
