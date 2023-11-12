package com.bavt.finsap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAccountDetailsDto {

    private Integer UserId;
    private String Name;
    private String LastName;
    private String UserName;
    private String Email;
    private String Password;
    private Float AccountBalance;
    private Date CreateDate;
    private Date UpdateDate;

}
