package com.ecommerce.service;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.dto.RoleDto;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.Role;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto add(Role role);
    RoleDto delete(Long id);
    RoleDto findById(Long id);
}
