package com.siigroup.thales.devtest.service;

import com.siigroup.thales.devtest.model.dto.DummyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class DataService {

    private final RestTemplate restTemplate;
    private final String apiUrl = System.getenv("API_KEY");

    public DataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<DummyDTO> getEmployees(){
        ResponseEntity<DummyDTO> result;
        try {
            result = restTemplate.getForEntity(apiUrl + "/employees", DummyDTO.class);
        } catch (HttpStatusCodeException e){
            return new ResponseEntity<>(e.getStatusCode());
        }
        return result;
    }

    public ResponseEntity<DummyDTO> getEmployeeById(Integer id){
        StringBuilder urlV2 = new StringBuilder(apiUrl).append("/employee/").append(id);
        ResponseEntity<DummyDTO> result;
        try {
            result = restTemplate.getForEntity(urlV2.toString(), DummyDTO.class);
        } catch (HttpStatusCodeException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
        return result;
    }
}
