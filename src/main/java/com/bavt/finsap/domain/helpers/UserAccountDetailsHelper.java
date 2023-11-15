package com.bavt.finsap.domain.helpers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccountDetailsHelper {

    private Integer userId;
    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Float accountBalance;
    private Date createDate;
    private Date updateDate;

}
