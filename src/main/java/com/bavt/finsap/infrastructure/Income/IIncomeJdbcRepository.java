package com.bavt.finsap.infrastructure.Income;

public interface IIncomeJdbcRepository {

    Boolean insertIncomeUser(Integer userId, Float income);

}
