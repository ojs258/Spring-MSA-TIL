package com.example.userservice.service;

import com.example.userservice.domain.Order;
import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseFindUserDto;
import com.example.userservice.exception.UserNotFoundException;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public ResponseEntity<String> createUser(RequestCreateUserDto userDto) {
        userRepository.save(userDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body("회원 가입 완료");
    }

    @Override
    public ResponseEntity<ResponseFindUserDto> findUser(String uuid) {
        ResponseFindUserDto dto = ResponseFindUserDto
                .createDto(
                    userRepository.findUserByUuid(uuid)
                    .orElseThrow(UserNotFoundException::new)
                );
        dto.setOrders(List.of());

        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Override
    public ResponseEntity<List<ResponseFindUserDto>> findUsers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userRepository.findUsers());
    }
}
