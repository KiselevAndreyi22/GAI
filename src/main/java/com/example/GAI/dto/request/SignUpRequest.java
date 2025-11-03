package com.example.GAI.dto.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
    private String email;

    public String getEmail() {
        if (!isValidEmail(email)) {
            throw new RuntimeException("Некорректный формат email");
        }
        return email;
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(emailRegex);
    }
}