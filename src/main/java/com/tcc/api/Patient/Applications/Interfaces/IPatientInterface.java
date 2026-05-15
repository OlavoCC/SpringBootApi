package com.tcc.api.Patient.Applications.Interfaces;

import java.util.List;

import com.tcc.api.Patient.Dtos.Entry.EntryPatientDTO;
import com.tcc.api.Patient.Dtos.Return.ReturnPatientDTO;

public interface IPatientInterface {
    Boolean createUser(EntryPatientDTO dto);
    List<ReturnPatientDTO> ListUsers();
    ReturnPatientDTO ListUserById(int id);
}
