package com.olegnew.jvrestuserinformation.service;

import com.olegnew.jvrestuserinformation.model.UserInformation;

public interface UserInformationService {
    UserInformation get(Long id);
    UserInformation save(UserInformation userInformation);
}
