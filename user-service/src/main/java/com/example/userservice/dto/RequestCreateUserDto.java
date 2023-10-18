package com.example.userservice.dto;

import com.example.userservice.domain.User;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
@ToString
// DTO에 맞게 뽑아오는 쿼리를 돌릴땐 ToString을 제외 설정 해줘야한다.
public class RequestCreateUserDto {
    private String email;

    private String pw;

    private String name;

    private String userId;

    public User toEntity() {
        return User.builder()
                .email(email)
                .userId(userId)
                .encPw(pw)
                .name(name)
                .uuid(String.valueOf(UUID.randomUUID()))
                .createAt(LocalDateTime.now())
                .build();
    }
}
