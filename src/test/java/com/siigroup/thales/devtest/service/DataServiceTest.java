package com.siigroup.thales.devtest.service;

import com.siigroup.thales.devtest.model.dto.DummyDTO;
import com.siigroup.thales.devtest.model.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class DataServiceTest {

    @InjectMocks
    private DataService dataService;
    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp(){
        openMocks(this);
    }

    @Test
    void getEmployees() {
        DummyDTO dummy = new DummyDTO("status", "", "message");
        when(restTemplate.getForObject(anyString(), any())).thenReturn(dummy);

        DummyDTO result = dataService.getEmployees();

        assertNotNull(result);
        assertEquals(dummy, result);
    }

    @Test
    void getEmployeeById() {
        DummyDTO dummy = new DummyDTO("status", "", "message");
        Integer id = 1;
        when(restTemplate.getForObject(anyString(), any())).thenReturn(dummy);

        DummyDTO result = dataService.getEmployeeById(id);

        assertNotNull(result);
        assertEquals(dummy, result);
    }

    @Test
    void convertLinkHasMapToEmployee() {
        final Integer id = 3;
        final String employee_name = "Juan";
        final Integer employee_salary = 123456;
        final Integer employee_age = 42;
        final String profile_image = "";

        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("employee_name",employee_name);
        map.put("employee_salary",employee_salary);
        map.put("employee_age",employee_age);
        map.put("profile_image",profile_image);

        Employee result = dataService.convertLinkHasMapToEmployee(map);

        Assertions.assertEquals(id,result.getId());
        Assertions.assertEquals(employee_name,result.getEmployee_name());
        Assertions.assertEquals(employee_salary,result.getEmployee_salary());
        Assertions.assertEquals(employee_age,result.getEmployee_age());
        Assertions.assertEquals(profile_image,result.getProfile_image());
    }
}