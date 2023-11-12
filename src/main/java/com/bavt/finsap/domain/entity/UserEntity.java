package com.bavt.finsap.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date createDate;
    private Date updateDate;

}
