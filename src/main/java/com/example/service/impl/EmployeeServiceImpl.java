package com.example.service.impl;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.exception.EmployeeNotFoundException;
import com.example.mapper.Convertor;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmp(EmployeeDto employeeDto) {
        return Convertor.entity_to_dto(
                employeeRepository.save(Convertor.dto_to_employee(employeeDto)));
    }

    @Override
    public List<EmployeeDto> getAll() {
        return employeeRepository.findAll().stream()
                .map(Convertor::entity_to_dto).toList();
    }

    @Override
    public EmployeeDto getAnEmp(Long id) {
        return Convertor.entity_to_dto(employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("employee with id " + id + " not found...")));
    }

    @Override
    public String deleteEmp(Long id) {
        Employee eo = employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("employee with id " + id + " not found..."));
        employeeRepository.delete(eo);
        return "employee with id " + id + " deleted";
    }

    @Override
    public EmployeeDto updateEmp(Long id, EmployeeDto employeeDto) {
        Employee eo = employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("employee with id " + id + " not found..."));
        eo.setEno(employeeDto.eno());
        eo.setEname(employeeDto.ename());
        eo.setSalary(employeeDto.salary());
        eo.setDeptno(employeeDto.deptno());
        eo.setEmpJob(employeeDto.empJob());
        eo.setEmpmobile(employeeDto.empmobile());
        return Convertor.entity_to_dto(employeeRepository.save(eo));
    }
}
