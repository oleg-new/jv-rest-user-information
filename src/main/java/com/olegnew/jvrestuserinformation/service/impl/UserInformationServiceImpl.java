package com.olegnew.jvrestuserinformation.service.impl;

import com.olegnew.jvrestuserinformation.model.UserInformation;
import com.olegnew.jvrestuserinformation.repository.UserInformationRepository;
import com.olegnew.jvrestuserinformation.service.UserInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInformationServiceImpl implements UserInformationService {
    private final UserInformationRepository userInformationRepository;

    @Override
    public UserInformation get(Long id) {
        return userInformationRepository.getReferenceById(id);
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        return userInformationRepository.save(userInformation);
    }
}
