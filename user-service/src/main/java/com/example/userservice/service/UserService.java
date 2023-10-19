package com.example.userservice.service;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseFindUserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<String> createUser(RequestCreateUserDto userDto);

    ResponseEntity<ResponseFindUserDto> findUser(String uuid);

    ResponseEntity<List<ResponseFindUserDto>> findUsers();
}
