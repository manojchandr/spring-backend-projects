package com.synchrony.imgurapi.controllers;

import com.synchrony.imgurapi.domain.Image;
import com.synchrony.imgurapi.dto.image.ImageUploadResponseDto;
import com.synchrony.imgurapi.services.ImageService;
import com.synchrony.imgurapi.util.ImageUtility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * image upload, view and delete.
 * Integrate with Imgur API for on-prem service
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/image")
class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    ResponseEntity<ImageUploadResponseDto> uploadImage(
            @RequestParam("image") MultipartFile file,
            @RequestParam("token") String token) throws IOException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(imageService.uploadNewImage(file, token));
    }

    @GetMapping("/info/{token}")
    List<Image> getImageDetails(@PathVariable("token") String token) {

        return imageService.getAllImage(token);
    }

    @GetMapping("/{token}/{name}")
    ResponseEntity<byte[]> getImage(@PathVariable("name") String name
            , @PathVariable("token") String token) {
        Optional<Image> image = imageService.getOptionalImage(name, token);
        Image rawImage = null;
        if (image.isPresent()) {
            rawImage = image.get();
        }
        assert rawImage != null;
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(rawImage.getType()))
                .body(ImageUtility.decompressImage(rawImage.getImage()));
    }

    @DeleteMapping("/{token}/{name}")
    ResponseEntity<String> deleteUserByUniqueName(@PathVariable("name") String name,
                                                  @PathVariable("token") String token) {
        imageService.deleteImage(name,token);
        return new ResponseEntity<>("user :{} is removed" + name, HttpStatus.NO_CONTENT);
    }

}
