package com.example.userservice.dto;

import com.example.userservice.domain.User;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
@ToString
// DTO에 맞게 뽑아오는 쿼리를 돌릴땐 ToString을 제외 설정 해줘야한다.
public class RequestCreateUserDto {

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String pw;

    @NotNull
    @NotBlank
    private String name;

    public User toEntity() {

        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();

        return User.builder()
                .email(email)
                .encPw(pe.encode(pw))
                .name(name)
                .createAt(LocalDateTime.now())
                .build();
    }
}
