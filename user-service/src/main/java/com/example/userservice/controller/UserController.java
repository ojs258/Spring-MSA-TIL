package com.example.userservice.controller;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseUserDto;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @RequestMapping("health-check")
    public String healthCheck() {
        return "healty";
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(
            @Valid @RequestBody RequestCreateUserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/users/{uuid}")
    public ResponseEntity<ResponseUserDto> findUser(@PathVariable("uuid") String uuid){
        return userService.findUser(uuid);
    }
}
