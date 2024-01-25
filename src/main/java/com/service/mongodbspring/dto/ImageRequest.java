package com.service.mongodbspring.dto;

import lombok.Data;

@Data
public class ImageRequest {
    private String imageName;
    private String imageDescription;
    private String imageLocation;
}
