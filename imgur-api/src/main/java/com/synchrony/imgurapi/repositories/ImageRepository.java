package com.synchrony.imgurapi.repositories;

import com.synchrony.imgurapi.domain.Image;
import com.synchrony.imgurapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);

    List<Image> findByUser(User user);
}
