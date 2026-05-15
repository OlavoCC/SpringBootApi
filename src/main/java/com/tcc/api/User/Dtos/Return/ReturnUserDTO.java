package com.tcc.api.User.Dtos.Return;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnUserDTO {

    private int id;
    private String name;
    private String lastName;
    private String cpf;
    private String age;
    private String role;
}