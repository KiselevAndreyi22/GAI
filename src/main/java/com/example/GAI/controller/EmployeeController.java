package com.example.GAI.controller;

import com.example.GAI.dto.request.EnterEmployeeRequest;
import com.example.GAI.dto.response.EmployeeDto;
import com.example.GAI.exception.IncorrectDataEntryException;
import com.example.GAI.model.Employee;
import com.example.GAI.model.User;
import com.example.GAI.service.impl.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/docs")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/enter-empl")
    public ResponseEntity<?> enterWorkBook(@RequestBody EnterEmployeeRequest enterRequest) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        try {
            Employee workBook = Employee.builder()
                    .firstName(enterRequest.getFirstName())
                    .lastName(enterRequest.getLastName())
                    .patronymic(enterRequest.getPatronymic())
                    .birthDate(enterRequest.getBirthDate())
                    .position(enterRequest.getPosition())
                    .snils(enterRequest.getSnils())
                    .userId(enterRequest.getUserId())
                    .build();

            employeeService.enter(workBook);
            EmployeeDto workBookDto = employeeService.toDTO(workBook);
            return ResponseEntity.ok(workBookDto);
        }
        catch (IncorrectDataEntryException e){
            return ResponseEntity.badRequest().body("Неккоректно введены паспортные данные или номер снилс!");
        }
    }
}
