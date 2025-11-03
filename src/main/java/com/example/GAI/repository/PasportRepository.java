package com.example.GAI.repository;

import com.example.GAI.model.Pasport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasportRepository extends JpaRepository<Pasport, Long> {
    boolean existsPasportByUser_Id(Long userId);
}
