package com.bavt.finsap.infrastructure;

import com.bavt.finsap.domain.entity.UserEntity;
import com.bavt.finsap.dto.UserDto;

import java.util.List;

public interface IUserRepository {

    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    UserEntity createUser(UserEntity userEntity);
    UserEntity updateUser(Long id, UserEntity userEntity);
    void deleteUser(Long id);

}
