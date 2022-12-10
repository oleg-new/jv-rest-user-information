package com.olegnew.jvrestuserinformation.dto.mapper;

import com.olegnew.jvrestuserinformation.dto.request.UserInformationRequestDto;
import com.olegnew.jvrestuserinformation.dto.response.UserInformationResponseDto;
import com.olegnew.jvrestuserinformation.model.UserInformation;
import com.olegnew.jvrestuserinformation.service.DateService;
import org.springframework.stereotype.Component;

@Component
public class UserInformationMapper {
    private final DateService dateService = new DateService();

    public UserInformationResponseDto toDto(UserInformation userInformation) {
        UserInformationResponseDto responseDto = new UserInformationResponseDto();
        responseDto.setId(userInformation.getId());
        responseDto.setName(userInformation.getName());
        responseDto.setLastName(userInformation.getLastName());
        responseDto.setAge(dateService.getAge(userInformation.getDateOfBirth()));
        return responseDto;
    }

    public UserInformation toModel(UserInformationRequestDto requestDto) {
        UserInformation userInformation = new UserInformation();
        userInformation.setName(requestDto.getName());
        userInformation.setLastName(requestDto.getLastName());
        userInformation.setDateOfBirth(requestDto.getDateOfBirth());
        return userInformation;
    }
}
