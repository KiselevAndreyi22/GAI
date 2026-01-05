package com.example.GAI.controller.documentController;

import com.example.GAI.dto.request.documentRequest.EnterPasportRequest;
import com.example.GAI.dto.request.documentRequest.UpdatePasportLastNameRequest;
import com.example.GAI.dto.request.documentRequest.UpdatePasportSeriaNumberRequest;
import com.example.GAI.dto.response.documentDto.PasportDto;
import com.example.GAI.service.documentService.PasportService;
import com.example.GAI.service.userService.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docs")
@RequiredArgsConstructor
public class PasportController {

    private final PasportService pasportService;
    private final UserService userService;

    @PostMapping("/enter-pas")
    public PasportDto enterPasport(@Valid @RequestBody EnterPasportRequest enterRequest) {
        return pasportService.save(userService.getCurrentUser(), enterRequest);
    }

    @GetMapping("/get-pas")
    public PasportDto getPasport(){
        return pasportService.getByUser(userService.getCurrentUser());
    }

    @PatchMapping("/update-sn")
    public PasportDto updateSeriaNumber(@Valid @RequestBody UpdatePasportSeriaNumberRequest request){
        return new PasportDto(pasportService.updateSeriaNumber(userService.getCurrentUser(), request));
    }

    @PatchMapping("/update-ln")
    public PasportDto updateLastName(@Valid @RequestBody UpdatePasportLastNameRequest request){
        return new PasportDto(pasportService.updateLastName(userService.getCurrentUser(), request));
    }

    @DeleteMapping("/delete-pas")
    public void deletePasport(){
        pasportService.deleteByUser(userService.getCurrentUser());
    }

}
