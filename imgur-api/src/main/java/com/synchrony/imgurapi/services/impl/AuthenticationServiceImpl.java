package com.synchrony.imgurapi.services.impl;

import com.synchrony.imgurapi.domain.AuthenticationToken;
import com.synchrony.imgurapi.domain.User;
import com.synchrony.imgurapi.exception.AuthenticationException;
import com.synchrony.imgurapi.repositories.AuthenticationRepository;
import com.synchrony.imgurapi.services.AuthenticationService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationRepository authenticationRepository;

    public AuthenticationServiceImpl(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        authenticationRepository.save(authenticationToken);
    }

    @Override
    public AuthenticationToken getToken(User user) {
        return authenticationRepository.findByUser(user);
    }

    @Override
    public User getUser(String token) {
        final AuthenticationToken authenticationToken = authenticationRepository.findByToken(token);
        //return null check of token
        if(Objects.isNull(token)) return null;

        return authenticationToken.getUser();
    }

    @Override
    public void authenticateValidation(String token) {
        // token null check
        if(Objects.isNull(token)) throw new AuthenticationException("Token not available");
        // for invalid token check
        if(Objects.isNull(getUser(token))) throw new AuthenticationException("Token not valid");

    }
}
