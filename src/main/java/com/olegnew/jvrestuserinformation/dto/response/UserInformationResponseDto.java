package com.olegnew.jvrestuserinformation.dto.response;

import com.olegnew.jvrestuserinformation.service.DateService;
import java.time.LocalDate;
import lombok.Data;

@Data
public class UserInformationResponseDto {
    private DateService dateService;
    private Long id;
    private String name;
    private String lastName;
    private int age;

    public int getAge(LocalDate birthDate) {
        return dateService.getAge(birthDate);
    }
}
