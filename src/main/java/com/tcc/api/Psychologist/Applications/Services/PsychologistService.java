package com.tcc.api.Psychologist.Applications.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.api.Patient.Applications.Interfaces.IPatientInterface;
import com.tcc.api.Patient.Dtos.Entry.EntryPatientDTO;
import com.tcc.api.Patient.Dtos.Return.ReturnPatientDTO;
import com.tcc.api.Patient.Models.PatientModel;
import com.tcc.api.Psychologist.Applications.Interfaces.IPsychologistInterface;
import com.tcc.api.Psychologist.Dtos.Entry.EntryPsychologistDTO;
import com.tcc.api.Psychologist.Dtos.Return.ReturnPsychologistDTO;
import com.tcc.api.Psychologist.Models.PsychologistModel;
import com.tcc.api.Psychologist.Repository.InterfacesSql.IPsychologistInterfaceSql;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PsychologistService implements IPsychologistInterface{
    @Autowired
    private final IPsychologistInterfaceSql psychologistInterfaceSql;

    public Boolean createUser(EntryPsychologistDTO dto){
        var user = new PsychologistModel(dto.getName(), dto.getLastName(), dto.getCpf(), dto.getAge(), dto.getPassword(), dto.getRole(), dto.getCrp(), dto.getSpecialization());
        Boolean result = psychologistInterfaceSql.CreateUserSQl(user);
        if(result){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }
    public List<ReturnPsychologistDTO> ListUsers(){
        var result = psychologistInterfaceSql.ListUsersSQL();
        if(result != null){
            return result;
        }
        else{
            return null;
        }
    }

    public ReturnPsychologistDTO ListUserById(int id){
        var result = psychologistInterfaceSql.ListUserByIdSQL(id);
        return result;
    }
}
