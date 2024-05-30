package com.siigroup.thales.devtest.controller;

import com.siigroup.thales.devtest.model.dto.EmployeeDTO;
import com.siigroup.thales.devtest.model.entity.Employee;
import com.siigroup.thales.devtest.service.BusinessService;
import com.siigroup.thales.devtest.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class EmployeeController {

    private DataService dataService;
    private BusinessService businessService;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        List<LinkedHashMap<String, Object>> maps = (List<LinkedHashMap<String, Object>>) dataService.getEmployees().data();
        List<EmployeeDTO> employeesDTO = maps.stream()
                .map(stringObjectsLinkedHashMap -> dataService.convertLinkHasMapToEmployee(stringObjectsLinkedHashMap))
                .map(this::buildEmployeeDTO)
                .toList();
        return new ResponseEntity<>(employeesDTO, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
        LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) dataService.getEmployeeById(id).data();
        Employee employee = dataService.convertLinkHasMapToEmployee(map);
        return new ResponseEntity<>(buildEmployeeDTO(employee), HttpStatus.OK);
    }

    private EmployeeDTO buildEmployeeDTO(Employee employee){
        return new EmployeeDTO(employee.getId(), employee.getEmployee_name(), employee.getEmployee_salary(),
                employee.getEmployee_age(), employee.getProfile_image(),
                businessService.calculateAnualSalary(employee.getEmployee_salary()));
    }
}
