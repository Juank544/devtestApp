package com.siigroup.thales.devtest.service;

import com.siigroup.thales.devtest.model.dto.DummyDTO;
import com.siigroup.thales.devtest.model.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

@Service
public class DataService {

    private final RestTemplate restTemplate;
    private final String apiUrl = System.getenv("API_KEY");

    public DataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DummyDTO getEmployees() throws HttpStatusCodeException {
        Optional<DummyDTO> optional = Optional.ofNullable(restTemplate.getForObject(apiUrl + "/employees", DummyDTO.class));
        return optional.orElseThrow();
    }

    public DummyDTO getEmployeeById(Integer id) throws HttpStatusCodeException {
        Optional<DummyDTO> optional = Optional.ofNullable(restTemplate.getForObject(apiUrl + "/employee/" + id, DummyDTO.class));
        return optional.orElseThrow();
    }

    public Employee convertLinkHasMapToEmployee(Map<String, Object> hashMap){
        return Employee.builder().id((Integer) hashMap.get("id")).employee_name((String) hashMap.get("employee_name"))
                .employee_salary((Integer) hashMap.get("employee_salary"))
                .employee_age((Integer) hashMap.get("employee_age"))
                .profile_image((String) hashMap.get("profile_image")).build();
    }
}
