package com.example.GAI.dto.response;

import com.example.GAI.model.Pasport;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PasportDto {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfbirthday;
    private String firstName;
    private String lastName;
    private String patronymic;
    private Long seriaNumber;

    public PasportDto(){}

    public PasportDto(Pasport pasport){
        this.id = pasport.getId();
        this.dateOfbirthday = pasport.getDateOfBirthday();
        this.firstName = pasport.getFirstName();
        this.lastName = pasport.getLastName();
        this.patronymic = pasport.getPatronymic();
        this.seriaNumber = pasport.getSeriaNumber();
    }
}
