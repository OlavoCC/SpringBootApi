package com.tcc.api.Patient.Repository.InterfacesSql;

import java.util.List;

import com.tcc.api.Patient.Dtos.Return.ReturnPatientDTO;
import com.tcc.api.Patient.Models.PatientModel;

public interface IPatientInterfaceSql {
    Boolean CreateUserSQl(PatientModel model);
    List<ReturnPatientDTO> ListUsersSQL();
    ReturnPatientDTO ListUserByIdSQL(int id);
}
