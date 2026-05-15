package com.tcc.api.Patient.Controllers;


import com.tcc.api.Patient.Applications.Interfaces.IPatientInterface;
import com.tcc.api.Patient.Dtos.Entry.EntryPatientDTO;
import com.tcc.api.Patient.Dtos.Return.ReturnPatientDTO;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/Api/Patient")
public class PatientController {
    
    @Autowired
    private IPatientInterface userInterface;

    @PostMapping("CreatePatient")
    public ResponseEntity<Boolean> createUser(@RequestBody @Valid EntryPatientDTO dto) {
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
    @GetMapping("ListPatient")
    public ResponseEntity<List<ReturnPatientDTO>> ListUsers(){
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

    @GetMapping("ListPatientById/{id}")
    public ResponseEntity<ReturnPatientDTO> ListUserById(@PathVariable int id){
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
