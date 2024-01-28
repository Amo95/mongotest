package com.service.mongodbspring.model;

import com.service.mongodbspring.enums.Colors;
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
    private Colors color;

    public Product(String name, Double price, int quantity, String description, Colors color) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.color = color;
    }
}
