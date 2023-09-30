package com.synchrony.imgurapi.dto.image;

public class ImageUploadResponseDto {

    private String message;

    public ImageUploadResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
