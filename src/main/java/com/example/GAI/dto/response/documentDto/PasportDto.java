package com.example.GAI.dto.response.documentDto;

import com.example.GAI.model.documentModel.Pasport;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PasportDto {
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirthday;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String seriaNumber;
    private String region;

    public PasportDto(){}

    public PasportDto(Pasport pasport){
        this.userId = pasport.getUser().getId();
        this.dateOfBirthday = pasport.getDateOfBirthday();
        this.firstName = pasport.getFirstName();
        this.lastName = pasport.getLastName();
        this.patronymic = pasport.getPatronymic();
        this.seriaNumber = pasport.getSeriaNumber();
        this.region = pasport.getRegion();
    }
}
