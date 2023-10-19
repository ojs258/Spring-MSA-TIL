package com.example.userservice.controller;

import com.example.userservice.dto.RequestCreateUserDto;
import com.example.userservice.dto.ResponseFindUserDto;
import com.example.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user-service")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("health-check")
    public String healthCheck() {
        return "healty";
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(
            @Valid @RequestBody RequestCreateUserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/users/{uuid}")
    public ResponseEntity<ResponseFindUserDto> findUser(@PathVariable("uuid") String uuid){
        return userService.findUser(uuid);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<ResponseFindUserDto>> findUsers() {
        return userService.findUsers();
    }
}
