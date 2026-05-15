package com.tcc.api.Patient.Models;

import com.tcc.api.User.Models.UserModel;
public class PatientModel extends UserModel{
    public PatientModel(
        String name,
        String lastName,
        String cpf,
        String age,
        String password,
        String role
    ){
        super(name, lastName, cpf, age, password, role);
    }
}
