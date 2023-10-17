package com.example.userservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
@ToString
// DTO에 맞게 뽑아오는 쿼리를 돌릴땐 ToString을 제외 설정 해줘야한다.
public class RequestCreateUserDto {
    @Email
    private String email;

    @Size(min = 8, message ="비밀 번호는 최소 8글자 입니다.")
    @Size(max = 20, message ="비밀 번호는 최대 20글자 입니다.")
    private String pw;

    @NotBlank
    @NotNull
    private String name;

}
