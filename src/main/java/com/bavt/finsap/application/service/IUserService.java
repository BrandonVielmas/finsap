package com.bavt.finsap.application.service;

import com.bavt.finsap.domain.model.User;

import java.util.Optional;

public interface IUserService {

    Iterable<User> getUsers();
    Optional<User> getUser(Integer id);
    User saveUser(User user);
    void deleteUserById(Integer id);

}
