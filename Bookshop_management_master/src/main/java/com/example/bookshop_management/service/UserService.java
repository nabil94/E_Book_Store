package com.example.bookshop_management.service;

import com.example.bookshop_management.Model.User;
import com.example.bookshop_management.web.dto.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
}
