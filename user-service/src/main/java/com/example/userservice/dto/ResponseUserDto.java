package com.example.userservice.dto;

import com.example.userservice.domain.User;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
@ToString
// DTO에 맞게 뽑아오는 쿼리를 돌릴땐 ToString을 제외 설정 해줘야한다.
public class ResponseUserDto {
    private String email;

    private String userId;

    private String name;

    private String uuid;

    public static ResponseUserDto createDto(User findUser) {

        return ResponseUserDto.builder()
                .email(findUser.getEmail())
                .userId(findUser.getUserId())
                .name(findUser.getName())
                .uuid(findUser.getUuid()).build();
    }

}
