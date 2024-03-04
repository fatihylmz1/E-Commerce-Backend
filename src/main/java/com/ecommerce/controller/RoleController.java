package com.ecommerce.controller;


import com.ecommerce.dto.RoleDto;
import com.ecommerce.entity.Role;
import com.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
@CrossOrigin("*")
public class RoleController {
    private RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role")
    public List<RoleDto> showAll(){
        return roleService.findAll();
    }

    @GetMapping("/role/{id}")
    public RoleDto showById(@PathVariable Long id){
        return roleService.findById(id);
    }

    @DeleteMapping("/role/{id}")
    public RoleDto delete(@PathVariable Long id){
        return roleService.delete(id);
    }

    @PostMapping("/role")
    public RoleDto addRole(@RequestBody Role role){
        return roleService.add(role);
    }
}
