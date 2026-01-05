package com.example.GAI.dto.request.authRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignInRequest {

    @NotBlank(message = "Ввод имени пользователя или email обязателен")
    private String usernameOrEmail;

    @Size(max = 255, message = "Длина пароля должна быть не менее 255 символов")
    @NotBlank(message = "Пароль не может быть пустым")
    private String password;
}