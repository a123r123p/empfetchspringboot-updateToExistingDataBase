package com.example.dto;


import jakarta.validation.constraints.*;

public record EmployeeDto
        (
                Long eno,
                @NotBlank(message = "Name is required by Arpan")
                @Size(min = 3, max = 20)
                String ename,
                Double salary,
                @Min(3)
                @Max(7)
                Integer deptno,
                String empJob,
                @Pattern(regexp = "^[6-9]\\d{9}$", message = "Invalid Mobile No required by ARPAN")
                String empmobile
        ) {

}


