package com.tcc.api.Psychologist.Dtos.Entry;

import com.tcc.api.User.Dtos.Entry.EntryUserDTO;

import lombok.Data;

@Data
public class EntryPsychologistDTO extends EntryUserDTO{
    String crp;
    String specialization;
}
