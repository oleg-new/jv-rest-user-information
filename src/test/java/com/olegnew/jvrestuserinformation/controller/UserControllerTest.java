package com.olegnew.jvrestuserinformation.controller;

import com.olegnew.jvrestuserinformation.model.UserInformation;
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
        testUser.setId(50L);
        testUser.setName("UserName");
        testUser.setLastName("UserLastName");
        testUser.setDateOfBirth(LocalDate.of(1999, 2, 10));
        Mockito.when(userInformationService.get(50L)).thenReturn(testUser);

        RestAssuredMockMvc.when()
                .get("/user/50")
                .then()
                .statusCode(200)
                .body("id", Matchers.equalTo("50"));
    }
}