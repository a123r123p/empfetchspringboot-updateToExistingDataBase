package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "empspring")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @Column(name = "empno")
    private Long eno;
    private String ename;
    @Column(name = "sal")
    private Double salary;
    private Integer deptno;
    @Column(name = "job")
    private String empJob;
    @Column(name = "mobile")
    private String empmobile;
}
