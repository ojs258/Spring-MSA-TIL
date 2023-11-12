package com.example.userservice.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "users")
public class User{
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(updatable = false)
    private String userId;

    private String email;

    private String name;

    private String encPw;
    @PrePersist
    private void createUserId(){
        userId = String.valueOf(UUID.randomUUID());
    }
}
