package com.olegnew.jvrestuserinformation.controller;

import com.olegnew.jvrestuserinformation.model.UserInformation;
import com.olegnew.jvrestuserinformation.service.DateService;
import com.olegnew.jvrestuserinformation.service.UserInformationService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.time.LocalDate;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserInformationService userInformationService;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    private void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }
    @Test
    public void shouldShowUserById_Ok() {
        UserInformation testUser = new UserInformation();
        DateService dateService = new DateService();
        Long id = 50L;
        String name = "UserName";
        String lastName = "UserLastName";
        LocalDate dateOfBirth = LocalDate.of(1999, 2, 10);
        int age = dateService.getAge(dateOfBirth);
        testUser.setId(id);
        testUser.setName(name);
        testUser.setLastName(lastName);
        testUser.setDateOfBirth(dateOfBirth);
        Mockito.when(userInformationService.get(50L)).thenReturn(testUser);
        RestAssuredMockMvc.when()
                .get("/user/50")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo(id.intValue()))
                .body("name", Matchers.equalTo(name))
                .body("lastName", Matchers.equalTo(lastName))
                .body("age", Matchers.equalTo(age));
    }


}