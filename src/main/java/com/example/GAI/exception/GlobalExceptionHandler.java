package com.example.GAI.exception;

import com.example.GAI.dto.response.extraDto.HttpResponse;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @ExceptionHandler(ExamNotPassedException.class)
    public ResponseEntity<Object> handleExamNotPassedException(ExamNotPassedException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Данный пользователь не сдал экзамен!",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(ExamTimeTableNotFoundException.class)
    public ResponseEntity<Object> handleExamTimeTableNotFoundException(ExamTimeTableNotFoundException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Данного экзамена нет в расписании!",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(TicketNotFoundException.class)
    public ResponseEntity<Object> TicketNotFoundException(TicketNotFoundException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Билет не найден в базе!",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(ExamAlreadyPassedException.class)
    public ResponseEntity<Object> ExamAlreadyPassedException(ExamAlreadyPassedException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Данный пользователь сдал экзамен!",
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(ExamSessionAlreadyOpened.class)
    public ResponseEntity<Object> ExamSessionAlreadyOpened(ExamSessionAlreadyOpened e) {
        HttpResponse errorResponse = new HttpResponse(
                "Сессия экзамена уже открыта для данного пользователя!",
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(ExamNotFoundException.class)
    public ResponseEntity<Object> ExamNotFoundException(ExamNotFoundException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Не нашлось данных об успешной сдаче экзамена!",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(DriverLicenseIsAlreadyExistException.class)
    public ResponseEntity<Object> DriverLicenseIsAlreadyExistException(DriverLicenseIsAlreadyExistException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Данный пользователь уже имеет водительское удостоверение!",
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(DriverLicenseNotFoundException.class)
    public ResponseEntity<Object> DriverLicenseNotFoundException(DriverLicenseNotFoundException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Водительское удостоверние не найдено !",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(VehicleRegistrationAlreadyExistsException.class)
    public ResponseEntity<Object> VehicleRegistrationAlreadyExistsException(VehicleRegistrationAlreadyExistsException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Данное ТС уже зарегистрировано в системе!",
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(VehicleRegistrationNotFoundException.class)
    public ResponseEntity<Object> VehicleRegistrationNotFoundException(VehicleRegistrationNotFoundException e) {
        HttpResponse errorResponse = new HttpResponse(
                "СТС данного транспортного средства не найден в системе!",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(VehicleDiagnosisCardNotFoundException.class)
    public ResponseEntity<Object> VehicleDiagnosisCardNotFoundException(VehicleDiagnosisCardNotFoundException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Карта техосмотра для данного ТС не найдена!",
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(VehicleDiagnosticCardAlreadyExistsException.class)
    public ResponseEntity<Object> VehicleDiagnosticCardAlreadyExistsException(VehicleDiagnosticCardAlreadyExistsException e) {
        HttpResponse errorResponse = new HttpResponse(
                "Данное ТС уже прошло ТО!",
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @Override
    protected org.springframework.http.ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {

        List<Map<String, Object>> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> Map.of(
                        "object", err.getObjectName(),
                        "field", err.getField(),
                        "rejectedValue", err.getRejectedValue(),
                        "message", err.getDefaultMessage()
                ))
                .collect(Collectors.toList());

        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pd.setTitle("Ошибка валидации");
        pd.setDetail("Данные были введены некорректно");
        pd.setProperty("errors", errors);
        if (request instanceof ServletWebRequest swr) {
            pd.setInstance(URI.create(swr.getRequest().getRequestURI()));
        }

        return handleExceptionInternal(ex, pd, headers, HttpStatus.BAD_REQUEST, request);
    }

}