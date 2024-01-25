package com.service.mongodbspring.dto;

import com.service.mongodbspring.model.Image;
import lombok.Data;

@Data
public class ProductResponse {
    private String name;
    private Double price;
    private int quantity;
    private String description;
    private String imageUrl;
}