package com.example.GAI.dto.response;

import com.example.GAI.model.Role;
import com.example.GAI.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private String patronymic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
    private Role position;
    private Long snils;
    private Long userId;

    public EmployeeDto() {}

    public EmployeeDto(Employee employee){
        this.birthDate = employee.getBirthDate();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.patronymic = employee.getPatronymic();
        this.position = employee.getPosition();
        this.snils = employee.getSnils();
        this.userId = employee.getUserId();
    }
}
