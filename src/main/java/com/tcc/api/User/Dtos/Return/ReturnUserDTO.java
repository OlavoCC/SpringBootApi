package com.tcc.api.User.Dtos.Return;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnUserDTO {
    public int id;
    public String name;
    public String age;
    public String cpf;
    public String email;
    public String flag;

}
