package com.example.GAI.dto.request.documentRequest;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EnterPasportRequest {

    @NotBlank(message = "Поле требует обязательного заполнения!")
    private String firstName;

    @NotBlank(message = "Поле требует обязательного заполнения!")
    private String lastName;

    @NotBlank(message = "Поле требует обязательного заполнения!")
    private String patronymic;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dateOfBirthday;

    @NotBlank(message = "Поле требует обязательного заполнения!")
    private String region;

    @NotBlank(message = "Поле не должно быть пустым")
    @Pattern(
            regexp = "\\d{10}",
            message = "Поле должно состоять из 10 цифр!"
    )
    private String seriaNumber;
}
