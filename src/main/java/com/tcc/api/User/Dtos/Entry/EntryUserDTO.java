package com.tcc.api.User.Dtos.Entry;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EntryUserDTO {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String lastName;

    @NotBlank
    @Size(max = 11, min = 11)
    private String cpf;

    @NotBlank
    @Size(min = 1, max = 2)
    private String age;

    @NotBlank
    private String password;

    @NotBlank
    @Size(max = 1)
    private String role;



}