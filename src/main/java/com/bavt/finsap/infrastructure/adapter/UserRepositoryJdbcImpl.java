package com.bavt.finsap.infrastructure.adapter;

import com.bavt.finsap.infrastructure.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryJdbcImpl implements IUserRepositoryJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Iterable<UserEntity> getUsers() {
        return jdbcTemplate.queryForList("select id, name, lastName, email, password from users;"
                , UserEntity.class);
    }

    @Override
    public Optional<UserEntity> getUser(Integer id) {
        return Optional.empty();
    }

    @Override
    public UserEntity saveUser(UserEntity user) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {

    }
}
