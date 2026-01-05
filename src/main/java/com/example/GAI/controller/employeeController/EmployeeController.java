package com.example.GAI.controller.employeeController;

import com.example.GAI.dto.request.employeeRequest.EnterEmployeeRequest;
import com.example.GAI.dto.request.employeeRequest.FireEmployeeRequest;
import com.example.GAI.dto.response.employeeDto.EmployeeDto;
import com.example.GAI.service.employeeService.EmployeeService;
import com.example.GAI.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final UserService userService;

    @PostMapping("/enter-empl")
    public EmployeeDto enterEmployee(@RequestBody EnterEmployeeRequest enterRequest){
        return employeeService.save(enterRequest);
    }

    @GetMapping("/get-empl-all")
    public List<EmployeeDto> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get-all-cand")
    public List<EmployeeDto> getAllPotencialEmployees(){
        return employeeService.getAllPotencialEmployees();
    }

    @PatchMapping("/update-status")
    public void setStatusFired(@RequestBody FireEmployeeRequest request){
        employeeService.setStatusFiredById(request);
    }
}
