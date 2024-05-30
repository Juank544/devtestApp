package com.siigroup.thales.devtest.service;

import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    public Integer calculateAnualSalary(Integer salary) {
        return salary * 12;
    }
}
