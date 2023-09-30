package com.synchrony.imgurapi.repositories;

import com.synchrony.imgurapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
}
