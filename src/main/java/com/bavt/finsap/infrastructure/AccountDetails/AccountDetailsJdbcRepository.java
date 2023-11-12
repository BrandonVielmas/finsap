package com.bavt.finsap.infrastructure.AccountDetails;

import com.bavt.finsap.domain.entity.AccountDetailsEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

@Repository
public class AccountDetailsJdbcRepository implements IAccountDetailsRepository {

    private final JdbcTemplate _jdbcTemplate;

    public AccountDetailsJdbcRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public AccountDetailsEntity createAccountDetails(AccountDetailsEntity accountDetailsEntity) {

        String query = "insert into account_details (userId, userName) values (?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        _jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, accountDetailsEntity.getUserId());
            ps.setString(2, accountDetailsEntity.getUserName());
            return ps;
        }, keyHolder);

        if(keyHolder.getKey() != null) {
            accountDetailsEntity.setId(keyHolder.getKey().intValue());
            accountDetailsEntity.setAccountBalance(0F);
            accountDetailsEntity.setCreateDate(new Date());
            accountDetailsEntity.setUpdateDate(new Date());
        }

        return accountDetailsEntity;

    }

    @Override
    public AccountDetailsEntity getAccountDetailsById(Integer id) {
        return _jdbcTemplate.query("select ", rs -> {
            return new AccountDetailsEntity(
                    rs.getInt("id"),
                    rs.getInt("userId"),
                    rs.getString("userName"),
                    rs.getFloat("accountBalance"),
                    rs.getDate("createDate"),
                    rs.getDate("updateDate")
            );
        });
    }

    @Override
    public AccountDetailsEntity createAccountDetails(Integer id, String userName) {
        AccountDetailsEntity newAccountDetailsEntity = new AccountDetailsEntity(id, userName);
        return this.createAccountDetails(newAccountDetailsEntity);
    }

}