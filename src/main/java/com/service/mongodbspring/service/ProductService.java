package com.service.mongodbspring.service;

import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.dto.ProductResponse;
import com.service.mongodbspring.model.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> addProduct(ProductRequest request);
}
