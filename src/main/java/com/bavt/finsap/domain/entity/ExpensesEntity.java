package com.bavt.finsap.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpensesEntity {

    private Integer id;
    private Integer userId;
    private Float amountSpent;
    private String expenseDescription;
    private Date createDate;
    private Date updateDate;

}
