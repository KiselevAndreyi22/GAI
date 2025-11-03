package com.example.GAI.dto.request;

import com.example.GAI.exception.IncorrectDataEntryException;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EnterPasportRequest {
    private String firstName;
    private String lastName;
    private String patronymic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirthday;
    private Long seriaNumber;

    public Long getSeriaNumber(){
        if(seriaNumber.toString().length() != 10)
            throw new IncorrectDataEntryException();
        return seriaNumber;
    }
}
