package com.example.GAI.service.documentService;

import com.example.GAI.dto.request.documentRequest.EnterSnilsRequest;
import com.example.GAI.dto.response.documentDto.SnilsDto;
import com.example.GAI.exception.SnilsNotFoundException;
import com.example.GAI.mapper.SnilsMapper;
import com.example.GAI.model.documentModel.Snils;
import com.example.GAI.model.userModel.User;
import com.example.GAI.repository.documentRepository.SnilsRepository;
import com.example.GAI.service.SnilsService;
import com.example.GAI.service.userService.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class SnilsServiceImpl implements SnilsService {

    SnilsRepository snilsRepository;
    SnilsMapper snilsMapper;
    UserService userService;

    @Override
    public SnilsDto save(User user, EnterSnilsRequest enterRequest){
        Snils snils = snilsMapper.toEntity(enterRequest);
        snils.setUser(user);

        Snils savedSnils = snilsRepository.save(snils);
        return new SnilsDto(savedSnils);
    }

    @Transactional
    public void delete(User user) {

        if(!snilsRepository.existsByUserId(user.getId())){
            throw new SnilsNotFoundException();
        }

        snilsRepository.deleteById(user.getId());
    }


    @Override
    public SnilsDto getByUserId(Long userId){
        Optional<Snils> snils = snilsRepository.findSnilsByUserId(userId);
        return new SnilsDto(snils.orElse(null));
    }
}
