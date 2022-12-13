package com.olegnew.jvrestuserinformation.dto.response;

import com.olegnew.jvrestuserinformation.service.DateService;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private int age;

    public int getAge(LocalDate birthDate) {
        DateService dateService = new DateService();
        return dateService.getAge(birthDate);
    }
}
