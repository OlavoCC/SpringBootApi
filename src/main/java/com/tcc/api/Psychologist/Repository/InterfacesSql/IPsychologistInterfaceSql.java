package com.tcc.api.Psychologist.Repository.InterfacesSql;

import java.util.List;

import com.tcc.api.Psychologist.Dtos.Return.ReturnPsychologistDTO;
import com.tcc.api.Psychologist.Models.PsychologistModel;

public interface IPsychologistInterfaceSql {
    Boolean CreateUserSQl(PsychologistModel model);
    List<ReturnPsychologistDTO> ListUsersSQL();
    ReturnPsychologistDTO ListUserByIdSQL(int id);
}
