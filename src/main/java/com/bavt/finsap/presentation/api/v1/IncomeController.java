package com.bavt.finsap.presentation.api.v1;

import com.bavt.finsap.application.IIncomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/income")
@RestController
public class IncomeController {

    private final IIncomeService _incomeService;

    public IncomeController(IIncomeService incomeService) {
        _incomeService = incomeService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Boolean> saveIncomeUser(@PathVariable Integer userId, @RequestBody Float income) {
        return new ResponseEntity<>(_incomeService.insertIncomeUser(userId, income), HttpStatus.OK);
    }

}
