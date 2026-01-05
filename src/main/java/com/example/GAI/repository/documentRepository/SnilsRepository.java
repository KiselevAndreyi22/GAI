package com.example.GAI.repository.documentRepository;

import com.example.GAI.model.documentModel.Snils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SnilsRepository extends JpaRepository<Snils, Long> {
    boolean existsSnilsByNumber(String number);

    boolean existsByUserId(Long userId);
    Optional<Snils> findSnilsByUserId(Long userId);

    @Modifying
    @Query("DELETE FROM Snils s WHERE s.id = :id")
    void deleteById(@Param("id") Long id);

}
