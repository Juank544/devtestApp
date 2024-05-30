package com.siigroup.thales.devtest.service;

import com.siigroup.thales.devtest.model.dto.DummyDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

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
}
