package com.tcc.api.Psychologist.Dtos.Return;

import com.tcc.api.User.Dtos.Return.ReturnUserDTO;

public class ReturnPsychologistDTO extends ReturnUserDTO{
    String crp;
    String specialization;
    public ReturnPsychologistDTO(
            int id,
            String name,
            String lastName,
            String cpf,
            String age,
            String role,
            String cpr,
            String specialization
    ) {

        super(id, name, lastName, cpf, age, role);
        this.crp = crp;
        this.specialization = specialization;
    }
}
