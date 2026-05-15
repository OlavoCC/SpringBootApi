package com.tcc.api.User.Dtos.Entry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EntryUserDTO {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 3, min = 1)
    private String age;

    @NotBlank
    @Size(min = 7, max = 100)
    private String password;

    @NotBlank
    @Size(max = 11, min = 11)
    private String cpf;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(max = 1)
    private String flag;


}