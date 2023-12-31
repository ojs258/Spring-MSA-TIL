package com.example.userservice.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("해당 유저는 존재하지 않습니다.");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
