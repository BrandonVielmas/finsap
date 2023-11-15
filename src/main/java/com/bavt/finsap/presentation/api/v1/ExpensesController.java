package com.bavt.finsap.presentation.api.v1;

import com.bavt.finsap.domain.entity.ExpensesEntity;
import com.bavt.finsap.infrastructure.Expenses.IExpensesJdbcRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/expenses")
public class ExpensesController {

    private final IExpensesJdbcRepository _expensesRepository;

    public ExpensesController(IExpensesJdbcRepository expensesRepository) {
        _expensesRepository = expensesRepository;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ExpensesEntity>> getExpensesById(@PathVariable Integer userId) {
        return new ResponseEntity<>(_expensesRepository.getExpensesByUserId(userId), HttpStatus.OK);
    }

    @PostMapping ResponseEntity<ExpensesEntity> insertExpenseById(@RequestBody ExpensesEntity expensesEntity) {
        return new ResponseEntity<>(_expensesRepository.insertExpenseById(expensesEntity), HttpStatus.CREATED);
    }

}























