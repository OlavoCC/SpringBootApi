package com.tcc.api.Psychologist.Models;

import com.tcc.api.User.Models.UserModel;
import lombok.Data;

@Data
public class PsychologistModel extends UserModel{
    String crp;
    String specialization;
    public PsychologistModel(
        String name,
        String lastName,
        String cpf,
        String age,
        String password,
        String role,
        String crp,
        String specialization
    ){
        super(name, lastName, cpf, age, password, role);
        this.crp = crp;
        this.specialization = specialization;
    }
}
