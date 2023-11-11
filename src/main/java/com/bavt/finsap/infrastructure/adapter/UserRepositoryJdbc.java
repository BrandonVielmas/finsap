package com.bavt.finsap.infrastructure.adapter;

import com.bavt.finsap.domain.model.User;
import com.bavt.finsap.domain.puerto.IUserRepository;
import com.bavt.finsap.infrastructure.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryJdbc implements IUserRepository {

    private final IUserRepositoryJdbc _userRepositoryJdbc;

    public UserRepositoryJdbc(IUserRepositoryJdbc userRepositoryJdbc) {
        _userRepositoryJdbc = userRepositoryJdbc;
    }

    @Override
    public Iterable<User> getUsers() {
        Iterable<UserEntity> usersEntity = _userRepositoryJdbc.getUsers();
        List<User> users = new ArrayList<>();

        //Sustituir esto por el mapper
        for(UserEntity userEntity: usersEntity) {
            User user = new User(userEntity.getId(), userEntity.getName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getPassword());
            users.add(user);
        }

        return users;
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
