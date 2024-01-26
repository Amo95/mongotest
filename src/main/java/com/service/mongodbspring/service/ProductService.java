package com.service.mongodbspring.service;

import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.dto.ProductResponse;
import com.service.mongodbspring.model.Product;

public interface ProductService {
    Product addProduct(ProductRequest request);
}
