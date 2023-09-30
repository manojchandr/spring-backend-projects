package com.synchrony.imgurapi.dto.image;

public class ImgurUploadResponseDto {

    private ImageData data;
    private String successMessage;
    private String statusCode;

    public ImageData getData() {
        return data;
    }

    public void setData(ImageData data) {
        this.data = data;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
