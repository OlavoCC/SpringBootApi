package com.tcc.api.Psychologist.Repository.ServicesSql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcc.api.Patient.Dtos.Return.ReturnPatientDTO;
import com.tcc.api.Patient.Models.PatientModel;
import com.tcc.api.Psychologist.Dtos.Return.ReturnPsychologistDTO;
import com.tcc.api.Psychologist.Models.PsychologistModel;
import com.tcc.api.Psychologist.Repository.InterfacesSql.IPsychologistInterfaceSql;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PsychologistServiceSql implements IPsychologistInterfaceSql{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Boolean CreateUserSQl(PsychologistModel model) {
        try {
            entityManager.createNativeQuery(
                            "INSERT INTO `psychologist` (`name`, `age`, `password`, `cpf`, `lastName`, `role`, `crp`, `specialization`) " +
                                    "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)"
                    )
                    .setParameter(1, model.getName())
                    .setParameter(2, model.getAge())
                    .setParameter(3, model.getPassword())
                    .setParameter(4, model.getCpf())
                    .setParameter(5, model.getLastName())
                    .setParameter(6, model.getRole())
                    .setParameter(7, model.getCrp())
                    .setParameter(8, model.getSpecialization())
                    .executeUpdate();

            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
    public List<ReturnPsychologistDTO> ListUsersSQL() {
    try {

        List<Object[]> rows = entityManager.createNativeQuery(
                "SELECT id, name, lastName, cpf, age, role, crp, specialization FROM psychologist"
        ).getResultList();

        List<ReturnPsychologistDTO> result = new ArrayList<>();

        for (Object[] row : rows) {

            ReturnPsychologistDTO dto = new ReturnPsychologistDTO(
                    ((Number) row[0]).intValue(),
                    String.valueOf(row[1]),
                    String.valueOf(row[2]),
                    String.valueOf(row[3]),
                    String.valueOf(row[4]),
                    String.valueOf(row[5]),
                    String.valueOf(row[6]),
                    String.valueOf(row[7])
            );

            result.add(dto);
        }

        return result;

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}

    public ReturnPsychologistDTO ListUserByIdSQL(int id) {
        try {
            Object[] row = (Object[]) entityManager.createNativeQuery(
                            "SELECT id, name, lastName, cpf, age, role, crp, specialization FROM `psychologist` WHERE id = ?1"
                    )
                    .setParameter(1, id)
                    .getSingleResult();

            return new ReturnPsychologistDTO(
                    ((Number) row[0]).intValue(),
                    String.valueOf(row[1]),
                    String.valueOf(row[2]),
                    String.valueOf(row[3]),
                    String.valueOf(row[4]),
                    String.valueOf(row[5]),
                    String.valueOf(row[6]),
                    String.valueOf(row[7])
                    );
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Ou lance uma exceção personalizada
        }
    }
}
