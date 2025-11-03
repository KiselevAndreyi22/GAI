package com.example.GAI.repository;

import com.example.GAI.model.Employee;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;

import java.time.LocalDate;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("""
    SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END 
    FROM Pasport p
    WHERE 
            p.firstName = :firstName AND
            p.lastName = :lastName AND 
            p.patronymic = :patronymic AND 
            p.dateOfBirthday = :dateOfBirthday
""")
    boolean existsByPasport(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("patronymic") String patronymic,
            @Param("dateOfBirthday")LocalDate dateOfBirthday
            );
}
