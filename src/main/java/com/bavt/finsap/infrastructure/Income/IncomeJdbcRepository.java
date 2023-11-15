package com.bavt.finsap.infrastructure.Income;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;

@Repository
public class IncomeJdbcRepository implements  IIncomeJdbcRepository{

    private final JdbcTemplate _jdbcTemplate;

    public IncomeJdbcRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Boolean insertIncomeUser(Integer userId, Float income) {

        String query = "insert into income(userId, incomeEntered, incomeDescription) values (?, ?, ?)";

        int filasAfectadas = _jdbcTemplate.update(query,
            userId,
            income,
            "Sueldo");

        return filasAfectadas > 0;
    }
}
