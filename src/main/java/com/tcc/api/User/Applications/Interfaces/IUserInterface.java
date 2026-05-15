package com.tcc.api.User.Applications.Interfaces;

import com.tcc.api.User.Dtos.Entry.EntryUserDTO;
import com.tcc.api.User.Dtos.Return.ReturnUserDTO;

import java.util.List;



public interface IUserInterface {
    Boolean createUser(EntryUserDTO dto);
    List<ReturnUserDTO> ListUsers();
    ReturnUserDTO ListUserById(int id);
}
