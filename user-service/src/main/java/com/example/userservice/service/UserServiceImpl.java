package com.example.userservice.service;

import com.example.userservice.domain.User;
import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseCreateUserDto;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.rmi.server.UnicastRemoteObject;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public RequestCreateUserDto createUser(RequestCreateUserDto userDto) {
        User newUser = User.builder()
                .email(userDto.getEmail())
                .encPw(userDto.getPw())
                .name(userDto.getName())
                .build();

        userRepository.save(newUser);
        return null;
    }
}
