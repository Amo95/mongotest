package com.service.mongodbspring.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Image {
    private String imageName;
    private String imageDescription;
    private String imageLocation;
}
