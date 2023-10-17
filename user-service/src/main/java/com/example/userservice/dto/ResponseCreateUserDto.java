package com.example.userservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
@ToString
// DTO에 맞게 뽑아오는 쿼리를 돌릴땐 ToString을 제외 설정 해줘야한다.
public class ResponseCreateUserDto {
    @Email
    private String email;

    @Min(value = 8, message = "비밀번호는 최소 8글자 입니다.")
    private String pw;

    private String name;

}
