package com.example.userservice.service;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
//    @Transactional
    public ResponseEntity<String> createUser(RequestCreateUserDto userDto) {
        userRepository.save(userDto.toEntity());
        return ResponseEntity.ok("회원 가입 완료");
    }

    @Override
    public ResponseEntity<ResponseUserDto> findUser(String uuid) {
        return ResponseEntity.ok(ResponseUserDto.createDto(
                userRepository.findUserByUuid(uuid)));
    }
}
