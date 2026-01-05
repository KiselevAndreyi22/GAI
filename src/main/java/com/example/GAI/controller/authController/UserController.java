package com.example.GAI.controller.authController;

import com.example.GAI.dto.response.userDto.UserDto;
import com.example.GAI.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/me")
    public UserDto getCurrentUser() {
        return new UserDto(userService.getCurrentUser());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id){ return userService.getUserById(id); }

    @GetMapping("/all")
    public List<UserDto> getAllUser() { return userService.getAll(); }
}