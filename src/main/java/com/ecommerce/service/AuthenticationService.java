package com.ecommerce.service;

import com.ecommerce.entity.Role;
import com.ecommerce.entity.User;
import com.ecommerce.repository.RoleRepository;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public User register(String fullName,String email,String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role customerRole = roleRepository.findByAuthority("Customer").get();

        Set<Role> roles = new HashSet<>();
        roles.add(customerRole);

        User user = new User();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(encodedPassword);
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
