package com.siigroup.thales.devtest.controller;

import com.siigroup.thales.devtest.model.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Controller
@AllArgsConstructor
public class ViewController {

    private EmployeeController employeeController;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/table")
    public String table(Model model) {
        List<Employee> results = employeeController.getEmployees().getBody();
        model.addAttribute("results", results);
        return "table";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam Integer id, Model model) {
        if (!Objects.isNull(id)) {
            List<Employee> results = Collections.singletonList(employeeController.getEmployeeById(id).getBody());
            model.addAttribute("results", results);
        }
        return "table";
    }

    @ExceptionHandler(Exception.class)
    public String error(Exception ex, Model model) {
        model.addAttribute("exception", ex);
        return "error";
    }
}
