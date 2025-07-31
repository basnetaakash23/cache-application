package com.hibernate.cache.repository;

import com.hibernate.cache.dtos.UserDto;
import com.hibernate.cache.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query("SELECT new com.hibernate.cache.dtos.UserDto(u.username, u.email, u.phoneNumber) FROM UserEntity u")
    List<UserDto> findAllUsersAsDTO();

}
