package com.olegnew.jvrestuserinformation.dto.request;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserInformationRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private LocalDate dateOfBirth;

}
