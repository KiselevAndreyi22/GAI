package com.example.GAI.controller;

import com.example.GAI.dto.request.EnterPasportRequest;
import com.example.GAI.dto.response.PasportDto;
import com.example.GAI.exception.IncorrectDataEntryException;
import com.example.GAI.model.Pasport;
import com.example.GAI.model.User;
import com.example.GAI.service.impl.PasportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docs")
@RequiredArgsConstructor
public class PasportController {

    private final PasportService pasportService;

    @PostMapping("/enter-pas")
    public ResponseEntity<PasportDto> enterPasport(@RequestBody EnterPasportRequest enterRequest) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        try {
            Pasport pasport = Pasport.builder()
                    .dateOfBirthday(enterRequest.getDateOfBirthday())
                    .firstName(enterRequest.getFirstName())
                    .lastName(enterRequest.getLastName())
                    .patronymic(enterRequest.getPatronymic())
                    .seriaNumber(enterRequest.getSeriaNumber())
                    .user(user)
                    .build();

            pasportService.enter(pasport);
            PasportDto pasportDto = pasportService.toDTO(pasport);
            return ResponseEntity.ok(pasportDto);
        }
        catch (IncorrectDataEntryException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
