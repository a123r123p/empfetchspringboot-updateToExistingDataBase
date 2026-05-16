package com.example.service;

import com.example.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmp(EmployeeDto employeeDto);

    List<EmployeeDto> getAll();

    EmployeeDto getAnEmp(Long id);

    String deleteEmp(Long id);

    EmployeeDto updateEmp(Long id, EmployeeDto employeeDto);


}
