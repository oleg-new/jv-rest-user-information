package com.olegnew.jvrestuserinformation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.olegnew.jvrestuserinformation.model.UserInformation;
import com.olegnew.jvrestuserinformation.service.UserInformationService;
import java.time.LocalDate;
import java.time.Period;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestConfig.class)
@EnableConfigurationProperties({ServerProperties.class, WebProperties.class})
public class RestTemplateTest {
    @Autowired
    private  UserInformationService service;

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${server.address}")
    String serverAddress;
    @LocalServerPort
    Integer serverPort;

    String name = "UserName";
    String lastName = "UserLastName";
    LocalDate birthDate = LocalDate.of(1999, 2, 10);
    int age = Period.between(birthDate, LocalDate.now()).getYears();

    @BeforeEach
    private void setUp() {
        UserInformation testUser = new UserInformation();
        testUser.setName(name);
        testUser.setLastName(lastName);
        testUser.setDateOfBirth(birthDate);
        UserInformation save = service.save(testUser);
    }

    @Test
    public void getUser_Ok() {
        String requestUrl = "http://" + serverAddress + ":" + serverPort + "/user/1";
        ResultUser actualResultUser = restTemplate.getForObject(requestUrl, ResultUser.class);
        assertEquals(1L, actualResultUser.getId());
        assertEquals(name, actualResultUser.getName());
        assertEquals(lastName, actualResultUser.getLastName());
        assertEquals(age,actualResultUser.getAge());
    }
    @Data
    private static class ResultUser{
        private Long id;
        private String name;
        private String lastName;
        private int age;
    }
}
