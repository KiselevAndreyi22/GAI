package com.example.GAI.exception;

import com.example.GAI.dto.response.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotExistException(UserNotFoundException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Пользователь не найден!",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(IncorrectDataEntryException.class)
    public ResponseEntity<Object> handleIncorrectDataEntryException(IncorrectDataEntryException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Данные были введены некорректно!",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(PasportNotFoundException.class)
    public ResponseEntity<Object> handlePasportNotFoundException(PasportNotFoundException e){
        HttpResponse errorResponse = new HttpResponse(
                "Паспортные данные пользователя не найдены!",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(SnilsNotFoundException.class)
    public ResponseEntity<Object> handleSnilsNotFoundException(SnilsNotFoundException e){
        HttpResponse errorResponse = new HttpResponse(
                "Номер СНИЛС не найден!",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(IncorrectPasportDataException.class)
    public ResponseEntity<Object> handleIncorrectPasportDataException(IncorrectPasportDataException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Паспортные данные пользователя введены некорректно!",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

}