package com.example.mapper;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;

public class Convertor {
    public static EmployeeDto entity_to_dto(Employee employee) {
        return new EmployeeDto(
                employee.getEno(),
                employee.getEname(),
                employee.getSalary(),
                employee.getDeptno(),
                employee.getEmpJob(),
                employee.getEmpmobile());

    }

    public static Employee dto_to_employee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.eno(),
                employeeDto.ename(),
                employeeDto.salary(),
                employeeDto.deptno(),
                employeeDto.empJob(),
                employeeDto.empmobile());

    }
}
