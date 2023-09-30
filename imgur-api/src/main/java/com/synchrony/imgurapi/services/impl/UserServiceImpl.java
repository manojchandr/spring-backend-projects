package com.synchrony.imgurapi.services.impl;

import com.synchrony.imgurapi.domain.AuthenticationToken;
import com.synchrony.imgurapi.domain.User;
import com.synchrony.imgurapi.dto.ResponseDto;
import com.synchrony.imgurapi.dto.user.SignInDto;
import com.synchrony.imgurapi.dto.user.SignInResponseDto;
import com.synchrony.imgurapi.dto.user.SignUpDto;
import com.synchrony.imgurapi.exception.CustomException;
import com.synchrony.imgurapi.exception.ResourceNotFoundException;
import com.synchrony.imgurapi.repositories.UserRepository;
import com.synchrony.imgurapi.services.AuthenticationService;
import com.synchrony.imgurapi.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AuthenticationService authenticationService;

    public UserServiceImpl(UserRepository userRepository, AuthenticationService authenticationService) {
        this.userRepository = userRepository;
        this.authenticationService = authenticationService;
    }

    @Override
    public ResponseDto createUser(SignUpDto signUpDto) {
        //check if user already exist
        Optional<User> existingUser = Optional.ofNullable(this.userRepository.findByEmail(signUpDto.getEmail()));
        if (existingUser.isPresent()) {
            throw new CustomException("user already created");
        }
        // get password and encrypt using MD5
        String encryptedPassword = signUpDto.getPassword();
        try {
            encryptedPassword = hashPassword(signUpDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = new User(signUpDto.getFirstName(), signUpDto.getLastName(),
                signUpDto.getEmail(), encryptedPassword);

        userRepository.save(user);

        AuthenticationToken authenticationToken = new AuthenticationToken(user);

        authenticationService.saveConfirmationToken(authenticationToken);

        log.info("User {} created successfully",signUpDto.getEmail());
        ResponseDto responseDto = new ResponseDto("success", "user created successfully");
        return responseDto;
    }

    @Override
    public SignInResponseDto loginUser(SignInDto signInDto) {
        User user = userRepository.findByEmail(signInDto.getEmail());

        if (Objects.isNull(user)) {
            throw new CustomException("user is not valid");
        }

        //    password validation
        try {
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
                throw new CustomException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        AuthenticationToken token = authenticationService.getToken(user);
        //token validation
        if (Objects.isNull(token)) {
            throw new CustomException("token is not present");
        }
        log.info("User {} logged successfully",signInDto.getEmail());
        return new SignInResponseDto("success", token.getToken());
    }

    @Override
    public void deleteUser(String emailAddress) {
        Optional<User> existingUser = Optional.ofNullable(this.userRepository.findByEmail(emailAddress));

        if (existingUser.isPresent()) {
            this.userRepository.delete(existingUser.get());
        } else {
            throw new ResourceNotFoundException("Record not found with user name : " + emailAddress);
        }
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }
}
