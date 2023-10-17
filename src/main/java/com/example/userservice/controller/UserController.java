package com.example.userservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-service")
public class UserController {
    @RequestMapping("health-check")
    public String helthCheck() {
        return "healty";
    }
}
