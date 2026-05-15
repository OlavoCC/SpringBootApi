package com.tcc.api.Patient.Repository.ServicesSql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcc.api.Patient.Dtos.Return.ReturnPatientDTO;
import com.tcc.api.Patient.Models.PatientModel;
import com.tcc.api.User.Dtos.Return.ReturnUserDTO;
import com.tcc.api.User.Models.UserModel;
import com.tcc.api.Patient.Repository.InterfacesSql.IPatientInterfaceSql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PatientServiceSql implements IPatientInterfaceSql{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Boolean CreateUserSQl(PatientModel model) {
        try {
            entityManager.createNativeQuery(
                            "INSERT INTO `patient` (`name`, `age`, `password`, `cpf`, `lastName`, `role`) " +
                                    "VALUES (?1, ?2, ?3, ?4, ?5, ?6)"
                    )
                    .setParameter(1, model.getName())
                    .setParameter(2, model.getAge())
                    .setParameter(3, model.getPassword())
                    .setParameter(4, model.getCpf())
                    .setParameter(5, model.getLastName())
                    .setParameter(6, model.getRole())
                    .executeUpdate();

            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
    public List<ReturnPatientDTO> ListUsersSQL() {
    try {

        List<Object[]> rows = entityManager.createNativeQuery(
                "SELECT id, name, lastName, cpf, age, role FROM patient"
        ).getResultList();

        List<ReturnPatientDTO> result = new ArrayList<>();

        for (Object[] row : rows) {

            ReturnPatientDTO dto = new ReturnPatientDTO(
                    ((Number) row[0]).intValue(),
                    String.valueOf(row[1]),
                    String.valueOf(row[2]),
                    String.valueOf(row[3]),
                    String.valueOf(row[4]),
                    String.valueOf(row[5])
            );

            result.add(dto);
        }

        return result;

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

    public ReturnPatientDTO ListUserByIdSQL(int id) {
        try {
            Object[] row = (Object[]) entityManager.createNativeQuery(
                            "SELECT id, name, lastName, cpf, age, role FROM `patient` WHERE id = ?1"
                    )
                    .setParameter(1, id)
                    .getSingleResult();

            return new ReturnPatientDTO(
                    ((Number) row[0]).intValue(),
                    String.valueOf(row[1]),
                    String.valueOf(row[2]),
                    String.valueOf(row[3]),
                    String.valueOf(row[4]),
                    String.valueOf(row[5])
                    );
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Ou lance uma exceção personalizada
        }
    }
}
