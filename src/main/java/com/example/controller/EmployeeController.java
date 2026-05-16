package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    @Operation(summary = "Create Employee")
    public ResponseEntity<EmployeeDto> createNewEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmp(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "fetch all employees")
    public ResponseEntity<List<EmployeeDto>> getAll() {
        return ResponseEntity.ok(
                employeeService.getAll());
    }

    @GetMapping("{id}")
    @Operation(summary = "fetch an Employee")
    public ResponseEntity<EmployeeDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getAnEmp(id));

    }

    @PutMapping("{id}")
    @Operation(summary = "Update an Employee")
    public ResponseEntity<EmployeeDto> update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmp(id, employeeDto));
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete Employee")
    public ResponseEntity<String> deleteAnEmp(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.deleteEmp(id), HttpStatus.NO_CONTENT);
    }

}
