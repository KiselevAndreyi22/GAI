package com.example.GAI.service.impl;

import com.example.GAI.dto.response.EmployeeDto;
import com.example.GAI.exception.IncorrectPasportDataException;
import com.example.GAI.exception.PasportNotFoundException;
import com.example.GAI.exception.SnilsNotFoundException;
import com.example.GAI.exception.UserNotFoundException;
import com.example.GAI.model.Employee;
import com.example.GAI.repository.EmployeeRepository;
import com.example.GAI.repository.PasportRepository;
import com.example.GAI.repository.SnilsRepository;
import com.example.GAI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SnilsRepository snilsRepository;

    @Autowired
    private PasportRepository pasportRepository;

    public void enter(Employee employee) {
        if (!userRepository.existsById(employee.getUserId())) {
            throw new UserNotFoundException();
        }
        if(!pasportRepository.existsPasportByUser_Id(employee.getUserId())){
            throw new PasportNotFoundException();
        }
        if(!employeeRepository.existsByPasport(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPatronymic(),
                employee.getBirthDate())
        )
        {
            throw new IncorrectPasportDataException();
        }
        if(!snilsRepository.existsSnilsByNumber(employee.getSnils())){
            throw new SnilsNotFoundException();
        }
        employeeRepository.save(employee);
    }

    public EmployeeDto toDTO(Employee employee){ return new EmployeeDto(employee); }

}
