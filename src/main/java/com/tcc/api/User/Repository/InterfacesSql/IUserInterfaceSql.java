package com.tcc.api.User.Repository.InterfacesSql;


import ch.qos.logback.core.joran.sanity.Pair;
import com.tcc.api.User.Dtos.Login.EntryUserLoginDTO;
import com.tcc.api.User.Dtos.Return.ReturnUserDTO;
import com.tcc.api.User.Models.UserModel;
import com.tcc.api.User.Repository.Transporter.TrasnporterLoginResult;

import java.util.List;

public interface IUserInterfaceSql {
    Boolean CreateUserSQl(UserModel model);
    List<ReturnUserDTO> ListUsersSQL();
    ReturnUserDTO ListUserByIdSQL(int id);
    TrasnporterLoginResult UserLoginSQL(EntryUserLoginDTO dto);
}
