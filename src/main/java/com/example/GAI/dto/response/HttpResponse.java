package com.example.GAI.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class HttpResponse {
    private String message;
    private HttpStatus status;
}
