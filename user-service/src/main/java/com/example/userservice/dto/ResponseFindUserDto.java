package com.example.userservice.dto;

import com.example.userservice.domain.Order;
import com.example.userservice.domain.User;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Builder @AllArgsConstructor
@ToString
// DTO에 맞게 뽑아오는 쿼리를 돌릴땐 ToString을 제외 설정 해줘야한다.
public class ResponseFindUserDto {

    private String name;

    private String userId;

    private List<Order> orders;

    public static ResponseFindUserDto createDto(User findUser) {

        return ResponseFindUserDto.builder()
                .userId(findUser.getUserId())
                .name(findUser.getName()).build();
    }

    public ResponseFindUserDto(User findUser) {
        name = findUser.getName();
        userId = findUser.getUserId();
        orders = new ArrayList<>();
    }

}
