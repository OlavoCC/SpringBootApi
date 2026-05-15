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

    public String Name;
    public String Age;
    public String Password;
    public String CPF;
    public String Email;
    public String Flag;

    public UserModel(String Name, String Age, String Password, String CPF, String Email, String Flag){
        this.Name = Name;
        this.Age = Age;
        this.Password = Password;
        this.CPF = CPF;
        this.Email = Email;
        this.Flag = Flag;
    }
    public UserModel() {};
}