package com.example.GAI.repository.userRepository;

import com.example.GAI.model.documentModel.Pasport;
import com.example.GAI.model.employeeModel.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.GAI.model.userModel.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);
    Optional<User> findByEmail(String email);
    boolean existsById(Long Id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    @Query("""
    SELECT p
    FROM Pasport p
    LEFT JOIN Snils s
    ON p.user = s.user
    WHERE s.id IS NOT NULL
    ORDER BY p.id
""")
    List<Pasport> findAllByPasportsAndSnils();

}