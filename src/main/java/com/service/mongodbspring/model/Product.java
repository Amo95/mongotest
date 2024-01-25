package com.service.mongodbspring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private int quantity;
    private String description;
    private Image image;

    public Product(String name, Double price, int quantity, String description, Image image) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }
}