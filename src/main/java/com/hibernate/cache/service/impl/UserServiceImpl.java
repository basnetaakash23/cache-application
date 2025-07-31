package com.hibernate.cache.service.impl;

import com.hibernate.cache.dtos.UserDto;
import com.hibernate.cache.entities.UserEntity;
import com.hibernate.cache.repository.UserRepository;
import com.hibernate.cache.service.UserService;
import com.hibernate.cache.stats.HibernatePackageHelper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final HibernatePackageHelper statsHelper;

    public UserServiceImpl(UserRepository userRepository, HibernatePackageHelper statsHelper) {
        this.userRepository = userRepository;
        this.statsHelper = statsHelper;
    }

    @Override
    @Cacheable(value = "users", key="all")
    public List<UserEntity> getAllUsers() {

        List<UserEntity> userEntities = userRepository.findAll();
        statsHelper.printStats();
        return userEntities;
    }

    @Override
    @Cacheable(value = "users-dtos", key="dtos")
    public List<UserDto> getAllUsersByDtos() {
        return userRepository.findAllUsersAsDTO();
    }
}
