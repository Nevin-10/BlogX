package com.example.__spring_security.service;

import com.example.__spring_security.DTO.UserRegistrationDto;
import com.example.__spring_security.exception.UserExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    private final JdbcUserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(JdbcUserDetailsManager userDetailsManager) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public void registerUser(@Valid UserRegistrationDto userRegistrationDto) {

        if (userDetailsManager.userExists(userRegistrationDto.getUsername())) {
            throw new UserExistsException("User with username '" + userRegistrationDto.getUsername() + "' already exists.");
        }

        UserDetails user = User.builder()
                .username(userRegistrationDto.getUsername())
                .password(passwordEncoder.encode(userRegistrationDto.getPassword()))
                .roles(userRegistrationDto.getRole())
                .build();

        userDetailsManager.createUser(user);
    }
}
