package com.example.GAI.repository.employeeRepository;

import com.example.GAI.model.documentModel.Pasport;
import com.example.GAI.model.employeeModel.Employee;
import com.example.GAI.model.employeeModel.EmployeeStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    Optional<Employee> findEmployeeByUserId(Long userId);

    boolean existsByUserId(Long userId);

    @Transactional
    void deleteByUserId(Long userId);

    @Query("""
    SELECT p FROM Pasport p 
    LEFT JOIN Employee e
    ON p.id = e.userId
    WHERE e.status = :status
    ORDER BY p.id
""")
    List<Pasport> findAllPasportsByStatusIs(EmployeeStatus status);

    @Query("""
    SELECT p FROM Pasport p
    LEFT JOIN Employee e
        ON p.id = e.userId
    WHERE e.status = 'FIRED' OR e IS NULL
    ORDER BY p.id
""")
    List<Pasport> findAllPasports();

    @Query("""
    SELECT p FROM Pasport p
    LEFT JOIN Employee e
        ON p.id = e.userId
    WHERE e.status = 'FIRED' OR e IS NULL
    ORDER BY p.id
""")
    List<Pasport> findEmployeeByUserId();


}
