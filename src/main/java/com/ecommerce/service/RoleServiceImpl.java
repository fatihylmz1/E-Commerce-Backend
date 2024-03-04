package com.ecommerce.service;


import com.ecommerce.dto.RoleDto;
import com.ecommerce.entity.Role;
import com.ecommerce.exception.RoleException;
import com.ecommerce.repository.RoleRepository;
import com.ecommerce.util.RoleDtoConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        return RoleDtoConversion.convertRoleList(roles);
    }

    @Override
    public RoleDto add(Role role) {
        Role role1 = roleRepository.save(role);
        return RoleDtoConversion.convertRole(role1);
    }

    @Override
    public RoleDto delete(Long id) {
        RoleDto roleDto = findById(id);
        roleRepository.deleteById(id);
        return roleDto;
    }

    @Override
    public RoleDto findById(Long id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if(roleOptional.isPresent()){
            Role role = roleOptional.get();
            return RoleDtoConversion.convertRole(role);
        }
        throw new RoleException("Role with given id is not exist. " + id , HttpStatus.NOT_FOUND);
    }

}
