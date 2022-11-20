package com.olegnew.jvrestuserinformation.dto.response;

import com.olegnew.jvrestuserinformation.service.DateService;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserInformationResponseDto {
    DateService dateService;
    private Long id;
    private String name;
    private String lastName;
    public int getAge(LocalDate birthDate){
        return dateService.getAge(birthDate);
    }
}
