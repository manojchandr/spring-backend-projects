package com.synchrony.imgurapi.services;

import com.synchrony.imgurapi.domain.AuthenticationToken;
import com.synchrony.imgurapi.domain.User;

public interface AuthenticationService {

    void saveConfirmationToken(AuthenticationToken authenticationToken);

    AuthenticationToken getToken(User user);

    User getUser(String token);

    void authenticateValidation(String token);
}
