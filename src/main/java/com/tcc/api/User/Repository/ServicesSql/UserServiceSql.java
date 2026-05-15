package com.tcc.api.User.Repository.ServicesSql;


import com.tcc.api.User.Dtos.Return.ReturnUserDTO;
import com.tcc.api.User.Models.UserModel;
import com.tcc.api.User.Repository.InterfacesSql.IUserInterfaceSql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class UserServiceSql implements IUserInterfaceSql {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Boolean CreateUserSQl(UserModel model) {
        try {
            entityManager.createNativeQuery(
                            "INSERT INTO `user` (`name`, `age`, `password`, `cpf`, `email`, `flag`) " +
                                    "VALUES (?1, ?2, ?3, ?4, ?5, ?6)"
                    )
                    .setParameter(1, model.getName())
                    .setParameter(2, model.getAge())
                    .setParameter(3, model.getPassword())
                    .setParameter(4, model.getCPF())
                    .setParameter(5, model.getEmail())
                    .setParameter(6, model.getFlag())
                    .executeUpdate();

            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
    public List<ReturnUserDTO> ListUsersSQL(){
        try{
            List<Object[]> rows = entityManager.createNativeQuery(
                    "SELECT id, name, age, cpf, email, flag FROM `user`"
            ).getResultList();

            List<ReturnUserDTO> result = new ArrayList<>();
            for (Object[] row : rows) {
                ReturnUserDTO dto = new ReturnUserDTO(
                        ((Number) row[0]).intValue(),
                        (String) row[1],
                        (String) row[2],  // age
                        (String) row[3],  // cpf
                        (String) row[4],  // email
                        (String) row[5]   // flag
                );
                result.add(dto);
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ReturnUserDTO ListUserByIdSQL(int id){
        try{
            ReturnUserDTO dto = entityManager.createQuery(
                            "SELECT new ReturnUserDTO(u.name, u.age, u.cpf, u.email, u.flag) " +
                                    "FROM User u WHERE u.id = :id", ReturnUserDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
            return dto;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
