package com.service.mongodbspring.dto;

import com.service.mongodbspring.model.Image;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String name;
    private Double price;
    private int quantity;
    private String description;
}
