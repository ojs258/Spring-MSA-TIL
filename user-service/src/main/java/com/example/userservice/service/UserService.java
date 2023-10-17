package com.example.userservice.service;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseCreateUserDto;

public interface UserService {
    RequestCreateUserDto createUser(RequestCreateUserDto userDto);
}
