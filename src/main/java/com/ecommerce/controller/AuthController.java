package com.ecommerce.controller;

import com.ecommerce.dto.RegisterDto;
import com.ecommerce.entity.User;
import com.ecommerce.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ecommerce/auth")
@CrossOrigin("*")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/")
    public User register(@RequestBody RegisterDto registerDto){
        return authenticationService.register(registerDto.fullName(),registerDto.email(),registerDto.password());

    }

}
