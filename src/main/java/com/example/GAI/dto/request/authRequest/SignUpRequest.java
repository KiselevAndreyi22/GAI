package com.example.GAI.dto.request.authRequest;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {

    @NotBlank(message = "Имя пользователя не может быть пустым")
    private String username;

    @NotBlank(message = "Поле пароля обязательно для заполнения")
    @Size(max = 255, message = "Длина пароля должна быть не более 255 символов")
    private String password;

    @NotBlank(message = "Адрес электронной почты не может быть пустым")
    @Email(message = "Email должен быть в формате user@example.xxx")
    private String email;
}