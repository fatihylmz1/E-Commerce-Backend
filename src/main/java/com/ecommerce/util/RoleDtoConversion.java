package com.ecommerce.util;

import com.ecommerce.dto.AddressDto;
import com.ecommerce.dto.RoleDto;
import com.ecommerce.entity.Address;
import com.ecommerce.entity.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleDtoConversion {
    public static List<RoleDto> convertRoleList (List<Role> roles){
        List<RoleDto> roleDtos = new ArrayList<>();
        roles.stream().forEach(role ->
                roleDtos.add(new RoleDto(role.getAuthority())));
        return roleDtos;
    }

    public static RoleDto convertRole(Role role){
        return new RoleDto(role.getAuthority());
    }
}
