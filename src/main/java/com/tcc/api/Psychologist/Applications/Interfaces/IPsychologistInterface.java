package com.tcc.api.Psychologist.Applications.Interfaces;

import java.util.List;

import com.tcc.api.Psychologist.Dtos.Entry.EntryPsychologistDTO;
import com.tcc.api.Psychologist.Dtos.Return.ReturnPsychologistDTO;

public interface IPsychologistInterface {
    Boolean createUser(EntryPsychologistDTO dto);
    List<ReturnPsychologistDTO> ListUsers();
    ReturnPsychologistDTO ListUserById(int id);
}
