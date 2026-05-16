package com.tcc.api.User.Dtos.Login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnUserLoginDTO {
    private Boolean sucess;
    private String token;
}
