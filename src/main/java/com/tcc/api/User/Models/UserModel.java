package com.tcc.api.User.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String cpf;
    private String age;
    private String password;
    private String role;



    public UserModel(String name, String lastName, String cpf, String age, String password, String role){
        this.name = name;
        this.lastName = lastName;
        this.cpf = cpf;
        this.age = age;
        this.password = password;
        this.role = role;
    }
    public UserModel() {};
}