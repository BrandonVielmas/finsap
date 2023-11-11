package com.bavt.finsap.infrastructure.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UserEntity {

    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String password;

}
