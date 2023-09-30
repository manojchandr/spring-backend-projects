package com.synchrony.imgurapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.synchrony.imgurapi.domain.AuthenticationToken;
import com.synchrony.imgurapi.domain.Image;
import com.synchrony.imgurapi.domain.User;
import com.synchrony.imgurapi.dto.image.ImageUploadResponseDto;
import com.synchrony.imgurapi.repositories.AuthenticationRepository;
import com.synchrony.imgurapi.repositories.ImageRepository;
import com.synchrony.imgurapi.services.ImageService;
import com.synchrony.imgurapi.services.impl.AuthenticationServiceImpl;
import com.synchrony.imgurapi.services.impl.ImageServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

class ImageControllerTest {
    /**
     * Method under test: {@link ImageController#uploadImage(MultipartFile, String)}
     */
    @Test
    void testUploadImage() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any())).thenReturn(new AuthenticationToken());
        ImageController imageController = new ImageController(new ImageServiceImpl(
                new AuthenticationServiceImpl(authenticationRepository), mock(ImageRepository.class), null));
        ResponseEntity<ImageUploadResponseDto> actualUploadImageResult = imageController
                .uploadImage(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), "ABC123");
        assertNull(actualUploadImageResult.getBody());
        assertEquals(200, actualUploadImageResult.getStatusCodeValue());
        assertTrue(actualUploadImageResult.getHeaders().isEmpty());
        verify(authenticationRepository).findByToken((String) any());
    }

    /**
     * Method under test: {@link ImageController#uploadImage(MultipartFile, String)}
     */
    @Test
    void testUploadImage2() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any()))
                .thenReturn(new AuthenticationToken(new User("Jane", "Doe", "jane.doe@example.org", "iloveyou")));
        AuthenticationServiceImpl authenticationService = new AuthenticationServiceImpl(authenticationRepository);
        ImageRepository imageRepository = mock(ImageRepository.class);
        when(imageRepository.save((Image) any())).thenReturn(new Image());
        ImageController imageController = new ImageController(
                new ImageServiceImpl(authenticationService, imageRepository, null));
        ResponseEntity<ImageUploadResponseDto> actualUploadImageResult = imageController
                .uploadImage(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), "ABC123");
        assertNull(actualUploadImageResult.getBody());
        assertEquals(200, actualUploadImageResult.getStatusCodeValue());
        assertTrue(actualUploadImageResult.getHeaders().isEmpty());
        verify(authenticationRepository, atLeast(1)).findByToken((String) any());
        verify(imageRepository).save((Image) any());
    }

    /**
     * Method under test: {@link ImageController#uploadImage(MultipartFile, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUploadImage3() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "com.synchrony.imgurapi.services.ImageService.uploadNewImage(org.springframework.web.multipart.MultipartFile, String)" because "this.imageService" is null
        //       at com.synchrony.imgurapi.controllers.ImageController.uploadImage(ImageController.java:32)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any()))
                .thenReturn(new AuthenticationToken(new User("Jane", "Doe", "jane.doe@example.org", "iloveyou")));
        new AuthenticationServiceImpl(authenticationRepository);
        ImageController imageController = new ImageController(null);
        imageController.uploadImage(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))),
                "ABC123");
    }

    /**
     * Method under test: {@link ImageController#uploadImage(MultipartFile, String)}
     */
    @Test
    void testUploadImage4() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   jakarta.servlet.ServletException: Request processing failed: org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   org.springframework.web.multipart.MultipartException: Current request is not a multipart request
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)
        //       at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any()))
                .thenReturn(new AuthenticationToken(new User("Jane", "Doe", "jane.doe@example.org", "iloveyou")));
        new AuthenticationServiceImpl(authenticationRepository);
        ImageService imageService = mock(ImageService.class);
        when(imageService.uploadNewImage((MultipartFile) any(), (String) any()))
                .thenReturn(new ImageUploadResponseDto("Not all who wander are lost"));
        ImageController imageController = new ImageController(imageService);
        ResponseEntity<ImageUploadResponseDto> actualUploadImageResult = imageController
                .uploadImage(new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"))), "ABC123");
        assertTrue(actualUploadImageResult.hasBody());
        assertTrue(actualUploadImageResult.getHeaders().isEmpty());
        assertEquals(200, actualUploadImageResult.getStatusCodeValue());
        verify(imageService).uploadNewImage((MultipartFile) any(), (String) any());
    }

    /**
     * Method under test: {@link ImageController#getImageDetails(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetImageDetails() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.synchrony.imgurapi.exception.AuthenticationException: Token not valid
        //       at com.synchrony.imgurapi.services.impl.AuthenticationServiceImpl.authenticateValidation(AuthenticationServiceImpl.java:45)
        //       at com.synchrony.imgurapi.services.impl.ImageServiceImpl.getAllImage(ImageServiceImpl.java:80)
        //       at com.synchrony.imgurapi.controllers.ImageController.getImageDetails(ImageController.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any())).thenReturn(new AuthenticationToken());
        (new ImageController(new ImageServiceImpl(new AuthenticationServiceImpl(authenticationRepository),
                mock(ImageRepository.class), null))).getImageDetails("ABC123");
    }

    /**
     * Method under test: {@link ImageController#getImageDetails(String)}
     */
    @Test
    void testGetImageDetails2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any())).thenReturn(new AuthenticationToken());
        new AuthenticationServiceImpl(authenticationRepository);
        ImageService imageService = mock(ImageService.class);
        ArrayList<Image> imageList = new ArrayList<>();
        when(imageService.getAllImage((String) any())).thenReturn(imageList);
        List<Image> actualImageDetails = (new ImageController(imageService)).getImageDetails("ABC123");
        assertSame(imageList, actualImageDetails);
        assertTrue(actualImageDetails.isEmpty());
        verify(imageService).getAllImage((String) any());
    }

    /**
     * Method under test: {@link ImageController#getImage(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetImage() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any())).thenReturn(new AuthenticationToken());
        (new ImageController(new ImageServiceImpl(new AuthenticationServiceImpl(authenticationRepository),
                mock(ImageRepository.class), null))).getImage("Name", "ABC123");
    }

    /**
     * Method under test: {@link ImageController#getImage(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetImage2() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any())).thenReturn(new AuthenticationToken());
        new AuthenticationServiceImpl(authenticationRepository);
        ImageService imageService = mock(ImageService.class);
        when(imageService.getOptionalImage((String) any(), (String) any())).thenReturn(Optional.of(new Image()));
        (new ImageController(imageService)).getImage("Name", "ABC123");
    }

    /**
     * Method under test: {@link ImageController#getImage(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetImage3() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any())).thenReturn(new AuthenticationToken());
        new AuthenticationServiceImpl(authenticationRepository);
        ImageService imageService = mock(ImageService.class);
        when(imageService.getOptionalImage((String) any(), (String) any())).thenReturn(null);
        (new ImageController(imageService)).getImage("Name", "ABC123");
    }

    /**
     * Method under test: {@link ImageController#deleteUserByUniqueName(String, String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testDeleteUserByUniqueName() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.synchrony.imgurapi.exception.AuthenticationException: Token not valid
        //       at com.synchrony.imgurapi.services.impl.AuthenticationServiceImpl.authenticateValidation(AuthenticationServiceImpl.java:45)
        //       at com.synchrony.imgurapi.services.impl.ImageServiceImpl.getOptionalImage(ImageServiceImpl.java:123)
        //       at com.synchrony.imgurapi.services.impl.ImageServiceImpl.deleteImage(ImageServiceImpl.java:105)
        //       at com.synchrony.imgurapi.controllers.ImageController.deleteUserByUniqueName(ImageController.java:59)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any())).thenReturn(new AuthenticationToken());
        (new ImageController(new ImageServiceImpl(new AuthenticationServiceImpl(authenticationRepository),
                mock(ImageRepository.class), null))).deleteUserByUniqueName("Name", "ABC123");
    }

    /**
     * Method under test: {@link ImageController#deleteUserByUniqueName(String, String)}
     */
    @Test
    void testDeleteUserByUniqueName2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Diffblue AI was unable to find a test

        AuthenticationRepository authenticationRepository = mock(AuthenticationRepository.class);
        when(authenticationRepository.findByToken((String) any())).thenReturn(new AuthenticationToken());
        new AuthenticationServiceImpl(authenticationRepository);
        ImageService imageService = mock(ImageService.class);
        doNothing().when(imageService).deleteImage((String) any(), (String) any());
        ResponseEntity<String> actualDeleteUserByUniqueNameResult = (new ImageController(imageService))
                .deleteUserByUniqueName("Name", "ABC123");
        assertEquals("user :{} is removedName", actualDeleteUserByUniqueNameResult.getBody());
        assertEquals(204, actualDeleteUserByUniqueNameResult.getStatusCodeValue());
        assertTrue(actualDeleteUserByUniqueNameResult.getHeaders().isEmpty());
        verify(imageService).deleteImage((String) any(), (String) any());
    }
}

