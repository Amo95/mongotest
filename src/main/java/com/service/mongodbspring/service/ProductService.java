package com.service.mongodbspring.service;

import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.dto.ProductResponse;

public interface ProductService {
    ProductResponse addProduct(ProductRequest request);
}
