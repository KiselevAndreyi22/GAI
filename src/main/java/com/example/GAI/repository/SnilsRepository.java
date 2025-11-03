package com.example.GAI.repository;

import com.example.GAI.model.Snils;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SnilsRepository extends JpaRepository<Snils, Long> {
    boolean existsSnilsByNumber(Long number);
}
