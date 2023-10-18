package com.example.userservice.service;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseUserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> createUser(RequestCreateUserDto userDto);

    ResponseEntity<ResponseUserDto> findUser(String uuid);
}
