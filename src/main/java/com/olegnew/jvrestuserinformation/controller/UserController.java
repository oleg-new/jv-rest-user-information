package com.olegnew.jvrestuserinformation.controller;

import com.olegnew.jvrestuserinformation.dto.mapper.UserInformationMapper;
import com.olegnew.jvrestuserinformation.dto.response.UserInformationResponseDto;
import com.olegnew.jvrestuserinformation.model.UserInformation;
import com.olegnew.jvrestuserinformation.service.UserInformationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserInformationService service;
    private final UserInformationMapper mapper;

    public UserController(UserInformationService service, UserInformationMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public UserInformationResponseDto getById(@PathVariable Long id) {
        UserInformation user = service.get(id);
        return mapper.toDto(user);
    }
}
