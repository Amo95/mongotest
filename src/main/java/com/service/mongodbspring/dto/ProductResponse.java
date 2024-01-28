package com.service.mongodbspring.dto;

import lombok.Data;

@Data
public class ProductResponse {
    private String name;
    private Double price;
    private int quantity;
    private String description;
}
