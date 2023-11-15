package com.bavt.finsap.application;

import com.bavt.finsap.infrastructure.Income.IIncomeJdbcRepository;
import org.springframework.stereotype.Service;

@Service
public class IncomeService implements IIncomeService {

    private final IIncomeJdbcRepository _incomeRepository;

    public IncomeService(IIncomeJdbcRepository incomeRepository) {
        _incomeRepository = incomeRepository;
    }

    @Override
    public Boolean insertIncomeUser(Integer userId, Float income) {
        return _incomeRepository.insertIncomeUser(userId, income);
    }
}
