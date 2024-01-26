package com.service.mongodbspring.service.impl;

import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.model.Product;
import com.service.mongodbspring.repository.ProductRepository;
import com.service.mongodbspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(ProductRequest request) {
        Product product = addProductToDb(request);
        return productRepository.insert(product);
    }

    private Product addProductToDb(ProductRequest request) {
        return new Product(request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getDescription()
        );
    }
}
