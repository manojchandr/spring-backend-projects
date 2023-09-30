package com.synchrony.imgurapi.services;

import com.synchrony.imgurapi.domain.Image;
import com.synchrony.imgurapi.dto.image.ImageUploadResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ImageService {

    Optional<Image> getOptionalImage(String name, String token);
    ImageUploadResponseDto uploadNewImage(MultipartFile file, String token) throws IOException;

    List<Image> getAllImage(String token);

    void deleteImage(String name, String token);
}
