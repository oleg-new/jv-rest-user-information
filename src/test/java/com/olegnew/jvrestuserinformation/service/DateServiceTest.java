package com.olegnew.jvrestuserinformation.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.LocalDate;
import java.time.Period;
import org.junit.jupiter.api.Test;

class DateServiceTest {
    private DateService dateService = new DateService();

    @Test
    void ageCalculation_Ok(){
        LocalDate current = LocalDate.now();
        LocalDate testingDate = LocalDate.of(2020, 1, 1);
        int age = Period.between(testingDate, current).getYears();
        assertNotNull(dateService.getAge(testingDate));
        assertEquals(dateService.getAge(testingDate), age);
    }
}
