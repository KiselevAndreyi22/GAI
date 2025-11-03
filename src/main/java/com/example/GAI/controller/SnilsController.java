package com.example.GAI.controller;

import com.example.GAI.dto.request.EnterSnilsRequest;
import com.example.GAI.dto.response.SnilsDto;
import com.example.GAI.exception.IncorrectDataEntryException;
import com.example.GAI.model.Snils;
import com.example.GAI.model.User;
import com.example.GAI.service.impl.SnilsService;
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
public class SnilsController {

    private final SnilsService snilsService;

    @PostMapping("/enter-snls")
    public ResponseEntity<SnilsDto> enterPasport(@RequestBody EnterSnilsRequest enterRequest) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        try {
            Snils snils = Snils.builder()
                    .number(enterRequest.getNumber())
                    .user(user)
                    .build();

            snilsService.enter(snils);
            SnilsDto snilsDto = snilsService.toDTO(snils);
            return ResponseEntity.ok(snilsDto);
        }
        catch (IncorrectDataEntryException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
