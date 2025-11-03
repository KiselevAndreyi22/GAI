package com.example.GAI.service.impl;

import com.example.GAI.dto.response.PasportDto;
import com.example.GAI.model.Pasport;
import com.example.GAI.repository.PasportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasportService {

    @Autowired
    private PasportRepository passportRepository;

    public Pasport enter(Pasport pasport){
        return passportRepository.save(pasport);
    }

    public PasportDto toDTO(Pasport pasport) {
        return new PasportDto(pasport);
    }

}
