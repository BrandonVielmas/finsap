package com.bavt.finsap.infrastructure.Expenses;

import com.bavt.finsap.domain.entity.ExpensesEntity;

import java.util.List;

public interface IExpensesJdbcRepository {

    List<ExpensesEntity> getExpensesByUserId(Integer userId);
    ExpensesEntity insertExpenseById(ExpensesEntity expensesEntity);

}
