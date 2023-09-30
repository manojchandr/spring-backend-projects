package com.synchrony.imgurapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synchrony.imgurapi.domain.AuthenticationToken;
import com.synchrony.imgurapi.domain.User;
import com.synchrony.imgurapi.dto.ResponseDto;
import com.synchrony.imgurapi.dto.user.SignInDto;
import com.synchrony.imgurapi.dto.user.SignInResponseDto;
import com.synchrony.imgurapi.dto.user.SignUpDto;
import com.synchrony.imgurapi.exception.CustomException;
import com.synchrony.imgurapi.repositories.UserRepository;
import com.synchrony.imgurapi.services.AuthenticationService;
import com.synchrony.imgurapi.services.UserService;
import com.synchrony.imgurapi.services.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@WebMvcTest(UserController.class)
public class UserControllerUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    UserServiceImpl userServiceImpl;

    @MockBean
    UserRepository userRepository;
    @MockBean
    AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        userServiceImpl = new UserServiceImpl(userRepository,authenticationService);
    }

    @Test
    void signUpTest() throws Exception {
        SignUpDto signUpDto = new SignUpDto("Dan","Morris","me@test.com","pass123");
        ResponseDto createUser = userServiceImpl.createUser(signUpDto);
        Assert.notNull(createUser,"user object created successfully");

        given(userService.createUser(signUpDto)).willReturn(createUser);

        Assert.notNull(createUser,"user object created successfully");
        this.mockMvc.perform(post("/api/v1/user/signUp").with(csrf())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(redirectedUrl("http://localhost/login"))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void signInTest() throws Exception {
        signUpTestData();
        SignInDto sign = new SignInDto("me@test.com","pass123");
        //Positive successful login test
        User user1 = new User("Dan","Morris","me@test.com","32250170A0DCA92D53EC9624F336CA24");
        given(userRepository.findByEmail(sign.getEmail())).willReturn(user1);

        AuthenticationToken authenticationToken=new AuthenticationToken(user1);
        given(authenticationService.getToken(user1)).willReturn(authenticationToken);

        SignInResponseDto signInUserSuccess = userServiceImpl.loginUser(sign);

        given(userService.loginUser(sign)).willReturn(signInUserSuccess);
        this.mockMvc.perform(post("/api/v1/user/signing").with(csrf())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(redirectedUrl("http://localhost/login"))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    void signInFailureNotValidTest() {
        signUpTestData();
        SignInDto sign = new SignInDto("me@test.com","pass123");
        //Test user not valid
        given(userService.loginUser(sign)).willThrow(new CustomException("user is not valid"));
    }

    @Test
    void signInFailureWrongPasswordTest() {
        //Test wrong password
        signUpTestData();
        SignInDto sign = new SignInDto("me@test.com","pass123");

        User user = new User("Dan","Morris","me@test.com","pass123");
        given(userRepository.findByEmail(sign.getEmail())).willReturn(user);
        given(userService.loginUser(sign)).willThrow(new CustomException("wrong password"));
    }

    @Test
    void singInFailureInvalidTokenTest() {
        //Test token not valid
        signUpTestData();
        SignInDto sign = new SignInDto("me@test.com","pass123");
        User user = new User("Dan","Morris","me@test.com","32250170A0DCA92D53EC9624F336CA24");
        given(userRepository.findByEmail(sign.getEmail())).willReturn(user);
        given(userService.loginUser(sign)).willThrow(new CustomException("token is not present"));
    }

    private void signUpTestData() {
        SignUpDto signUpDto = new SignUpDto("Dan","Morris","me@test.com","pass123");
        ResponseDto createUser = userServiceImpl.createUser(signUpDto);
        given(userService.createUser(signUpDto)).willReturn(createUser);
    }
}
