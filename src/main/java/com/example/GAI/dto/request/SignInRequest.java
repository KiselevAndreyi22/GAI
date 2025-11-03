package com.example.GAI.dto.request;

import lombok.Data;

@Data
public class SignInRequest {
    private String usernameOrEmail;
    private String password;
}