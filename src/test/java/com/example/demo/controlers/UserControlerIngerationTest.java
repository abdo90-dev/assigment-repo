package com.example.demo.controlers;

import com.example.demo.Demo2Application;
import com.example.demo.model.Email;
import com.example.demo.model.User;
import com.example.demo.repositery.EmailRepository;
import com.example.demo.repositery.UserRepository;
import com.example.demo.services.EmailService;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;


@WebMvcTest(UserControler.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class UserControlerIngerationTest {

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @MockBean
    private EmailRepository emailRepository;
    @Autowired
    private EmailService emailService;
    @TestConfiguration
    static class UserServiceContextConfiguration{
        @Bean
        public UserService userService(){
            return new UserService();
        }
    }


    @Test
    void getAllUsers() {
        User user = new User("abdelhak","haddadi","abdo12@gmail.com","0675378571");
        User user2 = new User("abdo","DZ","abdoDZ64@gmail.com","0987654332");

        List<User> users = Arrays.asList(user,user2);
        given(userRepository.findAll()).willReturn(users);
        assertThat(userService.findAll()).hasSize(2).contains(user,user2);
    }

    @Test
    void addUser() {
        User user = new User("abdelhak","haddadi","abdo12@gmail.com","0675378571");
        given(userRepository.save(user)).willReturn(user);
        assertThat(userService.save(user).getFirstName()).isEqualTo("abdelhak");
    }

    @Test
    void getUserById() {
        User user = new User("abdelhak","haddadi","abdo12@gmail.com","0675378571");
        given(userRepository.save(user)).willReturn(user);
        assertThat(userService.getUserById(1l).getFirstName()).isEqualTo("abdelhak");
    }

    @Test
    void testAddEmail() {
        Email email = new Email(1l,"abdo2@gmail.com","hadda3@gmail.com","unit test","this is unit test");
        given(emailRepository.save(email)).willReturn(email);
        assertThat(emailService.createEmail(email).getId()).isEqualTo(1l);
    }

    @Test
    void emailsNum() {
        Email email = new Email(1l,"abdo2@gmail.com","hadda3@gmail.com","unit test","this is unit test");
        Email email2 = new Email(1l,"abdo2@gmail.com","abdelhak24@gmail.com","unit test","this is unit test");
        List<Email> emails = Arrays.asList(email,email2);

        given(emailRepository.findAll()).willReturn(emails);

        assertThat(emailService.getEmailsByUserId("abdo2@gmail.com")).isEqualTo(2);
    }
}