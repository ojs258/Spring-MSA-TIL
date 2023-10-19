package com.example.userservice.repository;

import com.example.userservice.domain.User;
import com.example.userservice.dto.ResponseFindUserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUserId(String userId);

    @Query("SELECT new com.example.userservice.dto.ResponseFindUserDto(u) FROM User u")
    List<ResponseFindUserDto> findUsers();
}
