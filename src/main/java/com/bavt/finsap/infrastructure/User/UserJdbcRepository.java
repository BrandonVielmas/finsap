package com.bavt.finsap.infrastructure.User;

import com.bavt.finsap.domain.entity.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

@Repository
public class UserJdbcRepository implements IUserRepository {

    private final JdbcTemplate _jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return _jdbcTemplate.query("select id, name, lastName, email, password from users;",
                (rs, rowNum) -> {
                    UserEntity user = new UserEntity();
                    user.setId(rs.getInt("id"));
                    user.setName(rs.getString("name"));
                    user.setLastName(rs.getString("lastName"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setCreateDate(rs.getDate("createDate"));
                    user.setUpdateDate(rs.getDate("updateDate"));
                    return user;
                });
    }


    @Override
    public UserEntity getUserById(Long id) {
        return null;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        String query = "INSERT INTO users (name, lastName, email, password) VALUES (?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        _jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, userEntity.getName());
            ps.setString(2, userEntity.getLastName());
            ps.setString(3, userEntity.getEmail());
            ps.setString(4, userEntity.getPassword());
            return ps;
        }, keyHolder);

        if (keyHolder.getKey() != null) {
            userEntity.setId(keyHolder.getKey().intValue());
            userEntity.setCreateDate(new Date());
            userEntity.setUpdateDate(new Date());
        }

        return userEntity;

    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userEntity) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
