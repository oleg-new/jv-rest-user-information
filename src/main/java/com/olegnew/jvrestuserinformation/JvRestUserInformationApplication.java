package com.olegnew.jvrestuserinformation;

import com.olegnew.jvrestuserinformation.model.UserInformation;
import com.olegnew.jvrestuserinformation.repository.UserInformationRepository;
import com.olegnew.jvrestuserinformation.service.UserInformationService;
import com.olegnew.jvrestuserinformation.service.impl.UserInformationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class JvRestUserInformationApplication {

    public static void main(String[] args) {
        private final UserInformationRepository userInformationRepository;
        UserInformation testUser = new UserInformation();
        SpringApplication.run(JvRestUserInformationApplication.class, args);
        testUser.setName("UserName");
        testUser.setName("UserLastName");
        testUser.setDateOfBirth(LocalDate.of(1999, 2, 10));
        userInformationRepository
        System.out.println("---------YYYYYYYYYYYYYYYYYY---------------");
    }

}
