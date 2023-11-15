package com.bavt.finsap.infrastructure.Expenses;

import com.bavt.finsap.domain.entity.ExpensesEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

@Repository
public class ExpensesRepository implements IExpensesJdbcRepository{

    private final JdbcTemplate _jdbcTemplate;

    public ExpensesRepository(JdbcTemplate jdbcTemplate) {
        _jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ExpensesEntity> getExpensesByUserId(Integer userId) {
        String sql = "SELECT id, userId, amountSpent, expenseDescription, createDate, updateDate FROM expenses WHERE userId = ?";

        return _jdbcTemplate.query(sql, new Object[]{userId}, (rs, rowNum) -> {
            ExpensesEntity expensesEntity = new ExpensesEntity();

            expensesEntity.setId(rs.getInt("id"));
            expensesEntity.setUserId(rs.getInt("userId"));
            expensesEntity.setAmountSpent(rs.getFloat("amountSpent"));
            expensesEntity.setExpenseDescription(rs.getString("expenseDescription"));
            expensesEntity.setCreateDate(rs.getDate("createDate"));
            expensesEntity.setUpdateDate(rs.getDate("updateDate"));

            return expensesEntity;
        });
    }


    @Override
    public ExpensesEntity insertExpenseById(ExpensesEntity expensesEntity) {

        String query = "insert into expenses(userId, amountSpent, expenseDescription) values (?, ?, ?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        _jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, expensesEntity.getUserId());
            ps.setFloat(2, expensesEntity.getAmountSpent());
            ps.setString(3, expensesEntity.getExpenseDescription());

            return ps;
        }, keyHolder);

        if(keyHolder.getKey() != null) {
            expensesEntity.setId(keyHolder.getKey().intValue());
            expensesEntity.setCreateDate(new Date());
            expensesEntity.setUpdateDate(new Date());
        }else {
            return null;
        }

        return expensesEntity;
    }
}