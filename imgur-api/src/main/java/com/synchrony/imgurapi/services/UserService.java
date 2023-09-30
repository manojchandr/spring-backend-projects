package com.synchrony.imgurapi.services;

import com.synchrony.imgurapi.domain.User;
import com.synchrony.imgurapi.dto.ResponseDto;
import com.synchrony.imgurapi.dto.user.SignInDto;
import com.synchrony.imgurapi.dto.user.SignInResponseDto;
import com.synchrony.imgurapi.dto.user.SignUpDto;

import java.util.List;

public interface UserService {

    ResponseDto createUser(SignUpDto signUpDto);

    SignInResponseDto loginUser(SignInDto signInDto);

    void deleteUser(String userName);
}
