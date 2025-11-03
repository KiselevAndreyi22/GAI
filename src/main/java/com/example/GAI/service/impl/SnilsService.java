package com.example.GAI.service.impl;

import com.example.GAI.dto.response.SnilsDto;
import com.example.GAI.model.Snils;
import com.example.GAI.repository.SnilsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SnilsService {
    @Autowired
    SnilsRepository snilsRepository;

    public Snils enter(Snils snils){ return snilsRepository.save(snils); }

    public SnilsDto toDTO(Snils snils) { return new SnilsDto(snils); }
}
