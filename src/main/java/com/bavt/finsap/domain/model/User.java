package com.bavt.finsap.domain.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private Integer Id;
    private String Name;
    private String lastName;
    private String Email;
    private String Password;

}
