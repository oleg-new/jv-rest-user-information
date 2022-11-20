package com.olegnew.jvrestuserinformation.service;


import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;

@Service
public class DateService {
    public int getAge(LocalDate birthDate){
        if (birthDate != null){
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        return 0;
    }
}
