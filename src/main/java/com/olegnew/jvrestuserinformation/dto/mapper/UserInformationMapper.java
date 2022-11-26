package com.olegnew.jvrestuserinformation.dto.mapper;

import com.olegnew.jvrestuserinformation.dto.response.UserInformationResponseDto;
import com.olegnew.jvrestuserinformation.model.UserInformation;
import org.springframework.stereotype.Component;

@Component
public class UserInformationMapper {
    public UserInformationResponseDto toDto(UserInformation userInformation) {
        UserInformationResponseDto responseDto = new UserInformationResponseDto();
        responseDto.setId(userInformation.getId());
        responseDto.setName(userInformation.getName());
        responseDto.setLastName(userInformation.getLastName());
        responseDto.getAge(userInformation.getDateOfBirth());
        return responseDto;
    }
}
