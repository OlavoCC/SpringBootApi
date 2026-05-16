package com.tcc.api.User.Applications.Services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.tcc.api.Security.JwtService;
import com.tcc.api.User.Applications.Interfaces.IUserInterface;
import com.tcc.api.User.Dtos.Entry.EntryUserDTO;
import com.tcc.api.User.Dtos.Login.EntryUserLoginDTO;
import com.tcc.api.User.Dtos.Login.ReturnUserLoginDTO;
import com.tcc.api.User.Dtos.Return.ReturnUserDTO;


import com.tcc.api.User.Models.UserModel;
import com.tcc.api.User.Repository.InterfacesSql.IUserInterfaceSql;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService implements IUserInterface {
    @Autowired
    private final IUserInterfaceSql userInterfaceSql;
    @Autowired
    private final JwtService jwtService;

    public Boolean createUser(EntryUserDTO dto){
        var User = new UserModel(
                dto.getName(),
                dto.getLastName(),
                dto.getCpf(),
                dto.getAge(),
                dto.getPassword(),
                dto.getRole()
        );
        Boolean result = userInterfaceSql.CreateUserSQl(User);
        if(result){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }
    public List<ReturnUserDTO> ListUsers(){
        var result = userInterfaceSql.ListUsersSQL();
        if(result != null){
            return result;
        }
        else{
            return null;
        }
    }

    public ReturnUserDTO ListUserById(int id){
        var result = userInterfaceSql.ListUserByIdSQL(id);
        return result;
    }

    public ReturnUserLoginDTO UserLogin(EntryUserLoginDTO dto){
        var result = userInterfaceSql.UserLoginSQL(dto);
        if(result.getSucess()){
            String jwt = jwtService.generateToken(result.getId(), result.getRole());
            return new ReturnUserLoginDTO(Boolean.TRUE, jwt);
        }
        return null;
    }
}