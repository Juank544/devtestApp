package com.siigroup.thales.devtest.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Integer id;
    private String employeeName;
    private Integer employeeSalary;
    private Integer employeeAge;
    private String profileImage;
}
