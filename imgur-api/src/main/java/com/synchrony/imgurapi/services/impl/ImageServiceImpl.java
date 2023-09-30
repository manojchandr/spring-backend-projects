package com.synchrony.imgurapi.services.impl;

import com.synchrony.imgurapi.domain.Image;
import com.synchrony.imgurapi.domain.User;
import com.synchrony.imgurapi.dto.image.ImageUploadResponseDto;
import com.synchrony.imgurapi.dto.image.ImgurGetImageResponseDto;
import com.synchrony.imgurapi.dto.image.ImgurUploadResponseDto;
import com.synchrony.imgurapi.exception.AuthenticationException;
import com.synchrony.imgurapi.exception.CustomException;
import com.synchrony.imgurapi.repositories.ImageRepository;
import com.synchrony.imgurapi.services.AuthenticationService;
import com.synchrony.imgurapi.services.ImageService;
import com.synchrony.imgurapi.util.ImageUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final AuthenticationService authenticationService;

    private final ImageRepository imageRepository;

    private final WebClient webClient;

    @Value("{imgur.base.uri}")
    private String imgurUri;

    public ImageServiceImpl(AuthenticationService authenticationService, ImageRepository imageRepository, WebClient webClient) {
        this.authenticationService = authenticationService;
        this.imageRepository = imageRepository;
        this.webClient = webClient;
    }

    @Override
    public ImageUploadResponseDto uploadNewImage(MultipartFile file, String token) throws IOException {

        ImageUploadResponseDto imageUploadResponseDto = null;
        try {
            //validate the token
            authenticationService.authenticateValidation(token);

            User user = authenticationService.getUser(token);
            // copy of image stored in local db
            //TODO  -- can be modified to store just link and image object into imgur --
            imageRepository.save(
                    Image.builder().name(file.getOriginalFilename()).type(file.getContentType()).image(ImageUtility.compressImage(file.getBytes())).user(user)
                            .description(file.getName()).build());


            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(imgurUri+"/3/upload").queryParam("image", ImageUtility.compressImage(file.getBytes()));
            //uploading image to imgur
            Mono<ImgurUploadResponseDto> imgurUploadResponseDto = webClient.post()
                    .uri(builder.build().toUri())
                    .retrieve()
                    .bodyToMono(ImgurUploadResponseDto.class);

            log.info("Image uploaded successfully for Id {}" + imgurUploadResponseDto.block());

            imageUploadResponseDto = new ImageUploadResponseDto("Image uploaded successfully for Id {}" + imgurUploadResponseDto.block());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageUploadResponseDto;
    }

    @Override
    public List<Image> getAllImage(String token) throws AuthenticationException {
        // first authenticate if the token is valid
        authenticationService.authenticateValidation(token);

        User user = authenticationService.getUser(token);
        // fetch all images of respective user from local db
        //TODO made with image id from imgur and download all from imgur server
        final List<Image> dbImage = imageRepository.findByUser(user);

        if (dbImage.stream().anyMatch(image -> image.getUser().getId().equals(user.getId()))) {
            throw new AuthenticationException("User address {} does not have privilege" + user.getEmail());
        }

        //get all image from imgur for user
        Mono<ImgurGetImageResponseDto> imgurUploadResponseDto = webClient.get()
                .uri(imgurUri + "/3/account/manoj/images/")
                .retrieve()
                .bodyToMono(ImgurGetImageResponseDto.class);

        if (dbImage.isEmpty()) throw new CustomException("Image not found");

        return dbImage;
    }

    @Override
    public void deleteImage(String name, String token) {

        final Optional<Image> dbImage = getOptionalImage(name, token);
        if (dbImage.isPresent()) {
            Image image = dbImage.get();
            imageRepository.delete(image);

            //delete specific image from imgur for user
            Mono<ImgurGetImageResponseDto> imgurUploadResponseDto = webClient.delete()
                    .uri(imgurUri + "3/image/"+image.getId())
                    .retrieve()
                    .bodyToMono(ImgurGetImageResponseDto.class);
        } else {
            throw new CustomException("Image not found");
        }
    }

    @Override
    public Optional<Image> getOptionalImage(String name, String token) {
        // first authenticate if the token is valid
        authenticationService.authenticateValidation(token);
        // then fetch the user linked to the token

        User user = authenticationService.getUser(token);

        final Optional<Image> dbImage = imageRepository.findByName(name);

        if (dbImage.isPresent() && !dbImage.get().getUser().getId().equals(user.getId())) {
            throw new AuthenticationException("User address {} does not have privilege" + user.getEmail());
        }

        //get all image from imgur for user
        Mono<ImgurGetImageResponseDto> imgurUploadResponseDto = webClient.get()
                .uri(imgurUri + "/3/image/"+dbImage.get().getId())
                .retrieve()
                .bodyToMono(ImgurGetImageResponseDto.class);

        return dbImage;
    }
}
