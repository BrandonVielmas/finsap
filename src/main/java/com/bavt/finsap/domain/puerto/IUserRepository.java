package com.bavt.finsap.domain.puerto;

import com.bavt.finsap.domain.model.User;

import java.util.Optional;

public interface IUserRepository {

    Iterable<User> getUsers();
    Optional<User> getUser(Integer id);
    User saveUser(User user);
    void deleteUserById(Integer id);

}
