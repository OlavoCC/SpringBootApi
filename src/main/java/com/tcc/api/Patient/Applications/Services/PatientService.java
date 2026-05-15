package com.tcc.api.Patient.Applications.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcc.api.Patient.Applications.Interfaces.IPatientInterface;
import com.tcc.api.Patient.Repository.InterfacesSql.IPatientInterfaceSql;
import com.tcc.api.Patient.Dtos.Entry.EntryPatientDTO;
import com.tcc.api.Patient.Dtos.Return.ReturnPatientDTO;
import com.tcc.api.Patient.Models.PatientModel;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PatientService implements IPatientInterface {

    @Autowired
    private final IPatientInterfaceSql patientInterfaceSql;

    public Boolean createUser(EntryPatientDTO dto){
        var user = new PatientModel(dto.getName(), dto.getLastName(), dto.getCpf(), dto.getAge(), dto.getPassword(), dto.getRole());
        Boolean result = patientInterfaceSql.CreateUserSQl(user);
        if(result){
            return Boolean.TRUE;
        }
        else{
            return Boolean.FALSE;
        }
    }
    public List<ReturnPatientDTO> ListUsers(){
        var result = patientInterfaceSql.ListUsersSQL();
        if(result != null){
            return result;
        }
        else{
            return null;
        }
    }

    public ReturnPatientDTO ListUserById(int id){
        var result = patientInterfaceSql.ListUserByIdSQL(id);
        return result;
    }
}
