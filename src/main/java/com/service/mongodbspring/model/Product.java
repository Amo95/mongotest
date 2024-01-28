package com.service.mongodbspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Double price;
    private int quantity;
    private String description;

    public Product(String name, Double price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }
}
