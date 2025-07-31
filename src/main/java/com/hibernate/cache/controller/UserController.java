package com.hibernate.cache.controller;

import com.hibernate.cache.dtos.UserDto;
import com.hibernate.cache.entities.UserEntity;
import com.hibernate.cache.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/entities")

    public ResponseEntity<List<UserEntity>> getAllUsersWithEntity(){
        return ResponseEntity.ok().body(userService.getAllUsers());

    }

    @GetMapping("/dtos")

    public ResponseEntity<List<UserDto>> getAllUsersWithDto(){
        return ResponseEntity.ok().body(userService.getAllUsersByDtos());
    }
}
