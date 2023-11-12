package com.bavt.finsap.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String password;

}
