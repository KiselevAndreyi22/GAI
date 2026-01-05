package com.example.GAI.service.employeeService;

import com.example.GAI.dto.request.employeeRequest.EnterEmployeeRequest;
import com.example.GAI.dto.request.employeeRequest.FireEmployeeRequest;
import com.example.GAI.dto.response.employeeDto.EmployeeDto;
import com.example.GAI.exception.PasportNotFoundException;
import com.example.GAI.exception.SnilsNotFoundException;
import com.example.GAI.exception.UserNotFoundException;
import com.example.GAI.mapper.EmployeeMapper;
import com.example.GAI.model.documentModel.Pasport;
import com.example.GAI.model.employeeModel.Employee;
import com.example.GAI.model.employeeModel.EmployeeStatus;
import com.example.GAI.model.userModel.User;
import com.example.GAI.repository.employeeRepository.EmployeeRepository;
import com.example.GAI.repository.documentRepository.PasportRepository;
import com.example.GAI.repository.documentRepository.SnilsRepository;
import com.example.GAI.repository.userRepository.UserRepository;
import com.example.GAI.service.userService.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class EmployeeService {

    EmployeeRepository employeeRepository;

    UserRepository userRepository;

    SnilsRepository snilsRepository;

    PasportRepository pasportRepository;

    EmployeeMapper employeeMapper;

    UserService userService;

    public EmployeeDto save(EnterEmployeeRequest enterEmployeeRequest) {

        Employee employee = Employee.builder()
                .userId(enterEmployeeRequest.getUserId())
                .status(EmployeeStatus.LISTED)
                .build();


        if (!userRepository.existsById(employee.getUserId())) {
            throw new UserNotFoundException();
        }
        if(!pasportRepository.existsPasportByUserId(employee.getUserId())){
            throw new PasportNotFoundException();
        }
        if(!snilsRepository.existsByUserId(employee.getUserId())){
            throw new SnilsNotFoundException();
        }

        User user = userService.getById(enterEmployeeRequest.getUserId());
        user.setRole(enterEmployeeRequest.getRole());

        Employee savedEmployee = employeeRepository.save(employee);
        Pasport pasport = pasportRepository.findPasportByUser(userService.getById(enterEmployeeRequest.getUserId()));

        return new EmployeeDto(pasport);
    }

    public Employee getByUserId(Long id){
        Optional<Employee> employee = employeeRepository.findEmployeeByUserId(id);
        return employee.orElseThrow(null);
    }


    public List<EmployeeDto> getAllEmployees(){

        List<Pasport> employeeList = employeeRepository.findAllPasportsByStatusIs(EmployeeStatus.LISTED);

        return employeeList.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());

        /*List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());*/
    }

    public List<EmployeeDto> getAllPotencialEmployees(){

        List<Pasport> employeeList = employeeRepository.findAllPasports();

        return employeeList.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());

        /*List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());*/
    }

    @Transactional
    public void setStatusFiredById(FireEmployeeRequest request) {
        Employee employee = employeeRepository.findEmployeeByUserId(request.getUserId())
                .orElseThrow(UserNotFoundException::new);

        employee.setStatus(EmployeeStatus.FIRED);
    }

}
