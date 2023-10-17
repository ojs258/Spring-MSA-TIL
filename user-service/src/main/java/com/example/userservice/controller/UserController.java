package com.example.userservice.controller;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @RequestMapping("health-check")
    public String helthCheck() {
        return "healty";
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(
            @Valid @RequestBody RequestCreateUserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity.ok("회원 가입 완료");
    }
}
