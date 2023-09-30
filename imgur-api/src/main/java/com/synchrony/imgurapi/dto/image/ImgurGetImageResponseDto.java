package com.synchrony.imgurapi.dto.image;

import java.util.List;

public class ImgurGetImageResponseDto {

    private List<ImageData> imageDataList;

    public List<ImageData> getImageDataList() {
        return imageDataList;
    }

    public void setImageDataList(List<ImageData> imageDataList) {
        this.imageDataList = imageDataList;
    }
}
