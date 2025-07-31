package com.hibernate.cache.service;

import com.hibernate.cache.dtos.UserDto;
import com.hibernate.cache.entities.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> getAllUsers();

    List<UserDto> getAllUsersByDtos();

}
