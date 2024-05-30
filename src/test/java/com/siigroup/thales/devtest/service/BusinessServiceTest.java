package com.siigroup.thales.devtest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class BusinessServiceTest {

    @InjectMocks
    private BusinessService businessService;

    @Test
    void calculateAnnualSalary() {
        final Integer given = 1032000;

        Integer result = businessService.calculateAnnualSalary(86000);

        Assertions.assertEquals(given, result);
    }
}