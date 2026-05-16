package com.tcc.api.User.Controllers;

import com.tcc.api.User.Applications.Interfaces.IUserInterface;
import com.tcc.api.User.Dtos.Entry.EntryUserDTO;
import com.tcc.api.User.Dtos.Login.EntryUserLoginDTO;
import com.tcc.api.User.Dtos.Login.ReturnUserLoginDTO;
import com.tcc.api.User.Dtos.Return.ReturnUserDTO;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/User")
public class UserController {
    @Autowired
    private IUserInterface userInterface;

    @PostMapping("CreateUser")
    public ResponseEntity<Boolean> createUser(@RequestBody @Valid EntryUserDTO dto) {
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
    @GetMapping("ListUser")
    public ResponseEntity<List<ReturnUserDTO>> ListUsers(){
        try{
            var result = userInterface.ListUsers();
            if(result != null){
                return ResponseEntity.status(200).body(result);
            } else {
                return ResponseEntity.badRequest().body(result);
            }
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // 500
        }
    }

    @GetMapping("ListUserByid/{id}")
    public ResponseEntity<ReturnUserDTO> ListUserById(@PathVariable int id){
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

    @PostMapping("UserLogin")
    public ResponseEntity<ReturnUserLoginDTO> UserLogin(@RequestBody @Valid EntryUserLoginDTO dto){
        try{
            var result = userInterface.UserLogin(dto);
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
