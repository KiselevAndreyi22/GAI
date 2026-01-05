package com.example.GAI.controller.documentController;

import com.example.GAI.dto.request.documentRequest.EnterSnilsRequest;
import com.example.GAI.dto.response.documentDto.SnilsDto;
import com.example.GAI.service.documentService.SnilsServiceImpl;
import com.example.GAI.service.userService.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/docs")
@RequiredArgsConstructor
public class SnilsController {

    private final SnilsServiceImpl snilsService;
    private final UserService userService;

    @PostMapping("/enter-snls")
    public SnilsDto enterSnils(@Valid @RequestBody EnterSnilsRequest enterRequest) {
        return snilsService.save(userService.getCurrentUser(), enterRequest);
    }

    @GetMapping("/get-snls")
    public SnilsDto getSnils(){
        return snilsService.getByUserId(userService.getCurrentUser().getId());
    }

    @DeleteMapping("/delete-snls")
    public void deleteSnils() { snilsService.delete(userService.getCurrentUser());}
}
