package com.siigroup.thales.devtest.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
    private Integer id;
    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;
}
