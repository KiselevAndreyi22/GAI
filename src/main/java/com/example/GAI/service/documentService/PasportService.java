package com.example.GAI.service.documentService;

import com.example.GAI.dto.request.documentRequest.EnterPasportRequest;
import com.example.GAI.dto.request.documentRequest.UpdatePasportLastNameRequest;
import com.example.GAI.dto.request.documentRequest.UpdatePasportSeriaNumberRequest;
import com.example.GAI.dto.response.documentDto.PasportDto;
import com.example.GAI.exception.PasportNotFoundException;
import com.example.GAI.exception.UserNotFoundException;
import com.example.GAI.mapper.PasportMapper;
import com.example.GAI.model.documentModel.Pasport;
import com.example.GAI.model.userModel.User;
import com.example.GAI.repository.documentRepository.PasportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PasportService {

    PasportRepository pasportRepository;
    PasportMapper pasportMapper;

    public PasportDto save(User user, EnterPasportRequest enterPasportRequest){
        Pasport pasport = pasportMapper.toEntity(enterPasportRequest);
        pasport.setUser(user);

        Pasport savedPasport = pasportRepository.save(pasport);
        return new PasportDto(savedPasport);
    }

    public PasportDto getByUser(User user){
        //Optional<Pasport> pasport = pasportRepository.findPasportByUserId(userId);
        if(!pasportRepository.existsPasportByUserId(user.getId())){
            throw new PasportNotFoundException();
        }
        Pasport pasport = pasportRepository.findPasportByUser(user);
        return new PasportDto(pasport);
    }

    @Transactional
    public void deleteByUser(User user){
        if(!pasportRepository.existsPasportByUserId(user.getId())){
            throw new PasportNotFoundException();
        }
        Pasport pasport = pasportRepository.findPasportByUser(user);

        pasportRepository.deleteById(user.getId());
    }

    @Transactional
    public Pasport updateSeriaNumber(User user, UpdatePasportSeriaNumberRequest request) {

        if(!pasportRepository.existsPasportByUserId(user.getId())){
            throw new PasportNotFoundException();
        }

        Pasport pasport = pasportRepository.findPasportByUser(user);

        pasport.setSeriaNumber(request.getSeriaNumber());

        return pasport;
    }

    @Transactional
    public Pasport updateLastName(User user, UpdatePasportLastNameRequest request) {

        if(!pasportRepository.existsPasportByUserId(user.getId())){
            throw new PasportNotFoundException();
        }

        Pasport pasport = pasportRepository.findPasportByUser(user);

        pasport.setLastName(request.getLastName());

        return pasport;
    }

}
