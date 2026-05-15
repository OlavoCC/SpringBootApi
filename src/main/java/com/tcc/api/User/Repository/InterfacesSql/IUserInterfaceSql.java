package com.tcc.api.User.Repository.InterfacesSql;


import com.tcc.api.User.Dtos.Return.ReturnUserDTO;
import com.tcc.api.User.Models.UserModel;

import java.util.List;

public interface IUserInterfaceSql {
    Boolean CreateUserSQl(UserModel model);
    List<ReturnUserDTO> ListUsersSQL();
    ReturnUserDTO ListUserByIdSQL(int id);
}
