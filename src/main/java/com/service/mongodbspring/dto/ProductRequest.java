package com.service.mongodbspring.dto;

import com.service.mongodbspring.enums.Colors;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private String name;
    private Double price;
    private int quantity;
    private String description;
    private Colors color;
}
