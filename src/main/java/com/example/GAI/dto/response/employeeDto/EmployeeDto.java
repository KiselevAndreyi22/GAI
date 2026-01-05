package com.example.GAI.dto.response.employeeDto;

import com.example.GAI.model.documentModel.Pasport;
import com.example.GAI.model.employeeModel.EmployeeStatus;
import com.example.GAI.model.employeeModel.Employee;
import lombok.Data;

@Data
public class EmployeeDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private String patronymic;

    public EmployeeDto() {}

    public EmployeeDto(Pasport pasport){
        this.userId = pasport.getUser().getId();
        this.firstName = pasport.getFirstName();
        this.lastName = pasport.getLastName();
        this.patronymic = pasport.getPatronymic();
    }
}
