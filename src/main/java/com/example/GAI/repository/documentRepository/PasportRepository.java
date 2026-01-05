package com.example.GAI.repository.documentRepository;

import com.example.GAI.model.documentModel.Pasport;
import com.example.GAI.model.userModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PasportRepository extends JpaRepository<Pasport, Long> {
    boolean existsPasportByUserId(Long userId);
    Pasport findPasportByUser(User user);

    @Modifying
    @Query("DELETE FROM Pasport p WHERE p.id = :id")
    void deleteById(@Param("id") Long id);
}
