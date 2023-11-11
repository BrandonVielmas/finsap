package com.bavt.finsap.application.service;

import com.bavt.finsap.domain.model.User;
import com.bavt.finsap.domain.puerto.IUserRepository;

import java.util.Optional;

public class DomainUserService implements IUserService {

    private final IUserRepository _userRepository;

    public DomainUserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public Iterable<User> getUsers() {
        return _userRepository.getUsers();
    }

    @Override
    public Optional<User> getUser(Integer id) {
        return Optional.empty();
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }
}
