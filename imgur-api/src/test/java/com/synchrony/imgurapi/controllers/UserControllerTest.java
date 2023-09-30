package com.synchrony.imgurapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.synchrony.imgurapi.domain.AuthenticationToken;
import com.synchrony.imgurapi.domain.User;
import com.synchrony.imgurapi.dto.ResponseDto;
import com.synchrony.imgurapi.dto.user.SignInDto;
import com.synchrony.imgurapi.dto.user.SignInResponseDto;
import com.synchrony.imgurapi.dto.user.SignUpDto;
import com.synchrony.imgurapi.repositories.AuthenticationRepository;
import com.synchrony.imgurapi.repositories.UserRepository;
import com.synchrony.imgurapi.services.impl.AuthenticationServiceImpl;
import com.synchrony.imgurapi.services.impl.UserServiceImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

class UserControllerTest {
    /**
     * Method under test: {@link UserController#signUp(SignUpDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSignUp() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.synchrony.imgurapi.dto.user.SignUpDto]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.synchrony.imgurapi.dto.user.SignUpDto]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.synchrony.imgurapi.dto.user.SignUpDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1915)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:414)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1360)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1424)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2105)
        //       at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1481)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.synchrony.imgurapi.exception.CustomException: user already created
        //       at com.synchrony.imgurapi.services.impl.UserServiceImpl.createUser(UserServiceImpl.java:43)
        //       at com.synchrony.imgurapi.controllers.UserController.signUp(UserController.java:25)
        //   See https://diff.blue/R013 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByEmail((String) any()))
                .thenReturn(new User("Jane", "Doe", "jane.doe@example.org", "iloveyou"));
        when(userRepository.save((User) any())).thenReturn(new User("Jane", "Doe", "jane.doe@example.org", "iloveyou"));
        UserController userController = new UserController(
                new UserServiceImpl(userRepository, new AuthenticationServiceImpl(mock(AuthenticationRepository.class))));
        userController.signUp(new SignUpDto("Jane", "Doe", "jane.doe@example.org", "iloveyou"));
    }

    /**
     * Method under test: {@link UserController#signUp(SignUpDto)}
     */
    @Test
    void testSignUp2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.synchrony.imgurapi.dto.user.SignUpDto]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.synchrony.imgurapi.dto.user.SignUpDto]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.synchrony.imgurapi.dto.user.SignUpDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1915)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:414)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1360)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1424)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2105)
        //       at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1481)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByEmail((String) any())).thenReturn(null);
        when(userRepository.save((User) any())).thenReturn(new User("Jane", "Doe", "jane.doe@example.org", "iloveyou"));
        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.save((AuthenticationToken) any())).thenReturn(new AuthenticationToken());
        UserController userController = new UserController(
                new UserServiceImpl(userRepository, new AuthenticationServiceImpl(authenticationRepository)));
        ResponseDto actualSignUpResult = userController
                .signUp(new SignUpDto("Jane", "Doe", "jane.doe@example.org", "iloveyou"));
        assertEquals("user created successfully", actualSignUpResult.getMessage());
        assertEquals("success", actualSignUpResult.getStatus());
        verify(userRepository).findByEmail((String) any());
        verify(userRepository).save((User) any());
        verify(authenticationRepository).save((AuthenticationToken) any());
    }

    /**
     * Method under test: {@link UserController#signIn(SignInDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSignIn() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.synchrony.imgurapi.dto.user.SignInDto]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.synchrony.imgurapi.dto.user.SignInDto]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.synchrony.imgurapi.dto.user.SignInDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1915)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:414)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1360)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1424)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2105)
        //       at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1481)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.synchrony.imgurapi.exception.CustomException: wrong password
        //       at com.synchrony.imgurapi.services.impl.UserServiceImpl.loginUser(UserServiceImpl.java:77)
        //       at com.synchrony.imgurapi.controllers.UserController.signIn(UserController.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByEmail((String) any()))
                .thenReturn(new User("Jane", "Doe", "jane.doe@example.org", "iloveyou"));
        UserController userController = new UserController(
                new UserServiceImpl(userRepository, new AuthenticationServiceImpl(mock(AuthenticationRepository.class))));
        userController.signIn(new SignInDto("jane.doe@example.org", "iloveyou"));
    }

    /**
     * Method under test: {@link UserController#signIn(SignInDto)}
     */
    @Test
    void testSignIn2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.synchrony.imgurapi.dto.user.SignInDto]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.http.converter.HttpMessageConversionException: Type definition error: [simple type, class com.synchrony.imgurapi.dto.user.SignInDto]
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   com.fasterxml.jackson.databind.exc.InvalidDefinitionException: Cannot construct instance of `com.synchrony.imgurapi.dto.user.SignInDto` (no Creators, like default constructor, exist): cannot deserialize from Object value (no delegate- or property-based Creator)
        //    at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 2]
        //       at com.fasterxml.jackson.databind.exc.InvalidDefinitionException.from(InvalidDefinitionException.java:67)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportBadDefinition(DeserializationContext.java:1915)
        //       at com.fasterxml.jackson.databind.DatabindContext.reportBadDefinition(DatabindContext.java:414)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleMissingInstantiator(DeserializationContext.java:1360)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializerBase.deserializeFromObjectUsingNonDefault(BeanDeserializerBase.java:1424)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserializeFromObject(BeanDeserializer.java:352)
        //       at com.fasterxml.jackson.databind.deser.BeanDeserializer.deserialize(BeanDeserializer.java:185)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:323)
        //       at com.fasterxml.jackson.databind.ObjectReader._bindAndClose(ObjectReader.java:2105)
        //       at com.fasterxml.jackson.databind.ObjectReader.readValue(ObjectReader.java:1481)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByEmail((String) any()))
                .thenReturn(new User("Jane", "Doe", "jane.doe@example.org", "F25A2FC72690B780B2A14E140EF6A9E0"));
        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByUser((User) any())).thenReturn(new AuthenticationToken());
        UserController userController = new UserController(
                new UserServiceImpl(userRepository, new AuthenticationServiceImpl(authenticationRepository)));
        SignInResponseDto actualSignInResult = userController.signIn(new SignInDto("jane.doe@example.org", "iloveyou"));
        assertEquals("success", actualSignInResult.getStatus());
        assertNull(actualSignInResult.getToken());
        verify(userRepository).findByEmail((String) any());
        verify(authenticationRepository).findByUser((User) any());
    }

    /**
     * Method under test: {@link UserController#deleteUserByUniqueName(String)}
     */
    @Test
    void testDeleteUserByUniqueName() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        UserRepository userRepository = mock(UserRepository.class);
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findByEmail((String) any()))
                .thenReturn(new User("Jane", "Doe", "jane.doe@example.org", "iloveyou"));
        ResponseEntity<String> actualDeleteUserByUniqueNameResult = (new UserController(
                new UserServiceImpl(userRepository, new AuthenticationServiceImpl(mock(AuthenticationRepository.class)))))
                .deleteUserByUniqueName("janedoe");
        assertEquals("user :{} is removedjanedoe", actualDeleteUserByUniqueNameResult.getBody());
        assertEquals(204, actualDeleteUserByUniqueNameResult.getStatusCodeValue());
        assertTrue(actualDeleteUserByUniqueNameResult.getHeaders().isEmpty());
        verify(userRepository).findByEmail((String) any());
        verify(userRepository).delete((User) any());
    }

    /**
     * Method under test: {@link UserController#deleteUserByUniqueName(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUserByUniqueName2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.synchrony.imgurapi.exception.ResourceNotFoundException: Record not found with user name : janedoe
        //       at com.synchrony.imgurapi.services.impl.UserServiceImpl.deleteUser(UserServiceImpl.java:99)
        //       at com.synchrony.imgurapi.controllers.UserController.deleteUserByUniqueName(UserController.java:37)
        //   See https://diff.blue/R013 to resolve this issue.

        UserRepository userRepository = mock(UserRepository.class);
        doNothing().when(userRepository).delete((User) any());
        when(userRepository.findByEmail((String) any())).thenReturn(null);
        (new UserController(
                new UserServiceImpl(userRepository, new AuthenticationServiceImpl(mock(AuthenticationRepository.class)))))
                .deleteUserByUniqueName("janedoe");
    }
}

