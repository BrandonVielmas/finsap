package com.bavt.finsap.infrastructure.adapter;

import com.bavt.finsap.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepositoryJdbc {

    Iterable<UserEntity> getUsers();
    Optional<UserEntity> getUser(Integer id);
    UserEntity saveUser(UserEntity user);
    void deleteUserById(Integer id);

}
