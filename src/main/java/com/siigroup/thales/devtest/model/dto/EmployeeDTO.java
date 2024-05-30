package com.siigroup.thales.devtest.model.dto;

import java.io.Serializable;

public record EmployeeDTO(Integer id, String employee_name, Integer employee_salary, Integer employee_age, String profile_image, Integer employee_anual_salary) implements Serializable {
}
