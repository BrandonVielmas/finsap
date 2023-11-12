package com.bavt.finsap.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDetailsEntity {

    public AccountDetailsEntity(Integer userId, String userName) {
        this.setUserId(userId);
        this.setUserName(userName);
    }

    private Integer id;
    private Integer userId;
    private String userName;
    private Float accountBalance;
    private Date createDate;
    private Date updateDate;

}
