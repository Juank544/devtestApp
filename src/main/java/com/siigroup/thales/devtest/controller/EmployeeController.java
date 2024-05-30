package com.siigroup.thales.devtest.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siigroup.thales.devtest.model.dto.DummyDTO;
import com.siigroup.thales.devtest.model.entity.Employee;
import com.siigroup.thales.devtest.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class EmployeeController {

    private DataService dataService;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        Optional<DummyDTO> optional = dataService.getEmployees();
        if (optional.isPresent()) {
            List<Employee> list = (List<Employee>) optional.get().data();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) {
        Optional<DummyDTO> optional = dataService.getEmployeeById(id);
        if (optional.isPresent()) {
            ObjectMapper objectMapper = new ObjectMapper();
            Employee employee = objectMapper.convertValue(optional.get().data(), new TypeReference<>(){});
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
