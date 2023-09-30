package com.synchrony.imgurapi.controllers;

import com.synchrony.imgurapi.dto.ResponseDto;
import com.synchrony.imgurapi.dto.user.SignInDto;
import com.synchrony.imgurapi.dto.user.SignInResponseDto;
import com.synchrony.imgurapi.dto.user.SignUpDto;
import com.synchrony.imgurapi.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * User creation and login generate token to access image api
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
class UserController {

    private final UserService userService;

    //Sign up or register new user
    @PostMapping("/signup")
    ResponseDto signUp(@RequestBody SignUpDto signUpDto) {
        return userService.createUser(signUpDto);
    }

    // login a user
    @PostMapping("/signing")
    SignInResponseDto signIn(@RequestBody SignInDto signInDto) {
        return userService.loginUser(signInDto);
    }


    @DeleteMapping("/{userName}")
    ResponseEntity<String> deleteUserByUniqueName(@PathVariable("userName") String userName) {
        userService.deleteUser(userName);
        return new ResponseEntity<>("user :{} is removed" + userName, HttpStatus.NO_CONTENT);
    }

}
