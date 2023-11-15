package com.bavt.finsap.infrastructure.helpers;

import com.bavt.finsap.domain.helpers.UserAccountDetailsHelper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserAccountJdbcRepository implements IUserAccountRepository  {

    private final JdbcTemplate _jdbcTemplate;

    public UserAccountJdbcRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserAccountDetailsHelper getUserAccountById(Integer userId) {
        String sql = "SELECT u.id, u.name, u.lastName, ad.userName, u.email, u.password, ad.accountBalance, u.createDate, u.updateDate " +
                "FROM users u " +
                "INNER JOIN account_details ad ON u.id = ad.userId " +
                "WHERE u.id = ?";

        return _jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            UserAccountDetailsHelper userAccountDetailsHelper = new UserAccountDetailsHelper();
            userAccountDetailsHelper.setUserId((int) rs.getLong("id"));
            userAccountDetailsHelper.setName(rs.getString("name"));
            userAccountDetailsHelper.setLastName(rs.getString("lastName"));
            userAccountDetailsHelper.setUserName(rs.getString("userName"));
            userAccountDetailsHelper.setEmail(rs.getString("email"));
            userAccountDetailsHelper.setPassword("");
            userAccountDetailsHelper.setAccountBalance((float) rs.getDouble("accountBalance"));
            userAccountDetailsHelper.setCreateDate(rs.getDate("createDate"));
            userAccountDetailsHelper.setUpdateDate(rs.getDate("updateDate"));
            return userAccountDetailsHelper;
        }, userId);
    }
}
