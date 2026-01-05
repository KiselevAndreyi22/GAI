package com.example.GAI.dto.request.employeeRequest;

import com.example.GAI.model.employeeModel.EmployeeStatus;
import com.example.GAI.model.employeeModel.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnterEmployeeRequest {

    private Long userId;

    private Role role;

}