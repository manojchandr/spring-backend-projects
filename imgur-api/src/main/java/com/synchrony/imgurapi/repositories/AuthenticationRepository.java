package com.synchrony.imgurapi.repositories;

import com.synchrony.imgurapi.domain.AuthenticationToken;
import com.synchrony.imgurapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository  extends JpaRepository<AuthenticationToken, Integer> {

    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);
}
