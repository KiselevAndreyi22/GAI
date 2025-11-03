package com.example.GAI.dto.request;

import com.example.GAI.exception.IncorrectDataEntryException;
import com.example.GAI.model.Role;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EnterEmployeeRequest {
    private String firstName;
    private String lastName;
    private String patronymic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private Role position;
    private Long snils;
    private Long userId;

    public Long getSnils(){
        if(snils.toString().length() != 11)
            throw new IncorrectDataEntryException();
        return snils;
    }
}