package com.tcc.api.Psychologist.Controllers;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tcc.api.Patient.Applications.Interfaces.IPatientInterface;
import com.tcc.api.Patient.Dtos.Entry.EntryPatientDTO;
import com.tcc.api.Patient.Dtos.Return.ReturnPatientDTO;
import com.tcc.api.Psychologist.Applications.Interfaces.IPsychologistInterface;
import com.tcc.api.Psychologist.Dtos.Entry.EntryPsychologistDTO;
import com.tcc.api.Psychologist.Dtos.Return.ReturnPsychologistDTO;
@RestController
@RequestMapping("/Api/Psychologist")
public class PsychologistController {
    @Autowired
    private IPsychologistInterface userInterface;

    @PostMapping("CreatePsychologist")
    public ResponseEntity<Boolean> createUser(@RequestBody @Valid EntryPsychologistDTO dto) {
        try {
            Boolean result = userInterface.createUser(dto);
            if (result) {
                return ResponseEntity.status(201).body(result);
            } else {
                return ResponseEntity.badRequest().body(result);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // 500
        }
    }
    @GetMapping("ListPsychologist")
    public ResponseEntity<List<ReturnPsychologistDTO>> ListUsers(){
        try{
            var result = userInterface.ListUsers();
            if(result != null){
                return ResponseEntity.status(200).body(result);
            } else {
                return ResponseEntity.badRequest().body(result);
            }
        }catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.internalServerError().build(); // 500
        }
    }

    @GetMapping("ListPsychologistById/{id}")
    public ResponseEntity<ReturnPsychologistDTO> ListUserById(@PathVariable int id){
        System.out.println(id);
        try{
            var result = userInterface.ListUserById(id);
            if(result != null){
                return ResponseEntity.status(200).body(result);
            } else {
                return ResponseEntity.badRequest().body(result);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
