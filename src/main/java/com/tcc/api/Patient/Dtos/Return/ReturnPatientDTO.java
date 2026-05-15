package com.tcc.api.Patient.Dtos.Return;

import com.tcc.api.User.Dtos.Return.ReturnUserDTO;

public class ReturnPatientDTO extends ReturnUserDTO {

    public ReturnPatientDTO(
            int id,
            String name,
            String lastName,
            String cpf,
            String age,
            String role
    ) {

        super(id, name, lastName, cpf, age, role);
    }
}