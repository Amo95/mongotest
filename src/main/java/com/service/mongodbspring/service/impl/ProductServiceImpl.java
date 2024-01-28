package com.service.mongodbspring.service.impl;

import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.mapper.BasicMapper;
import com.service.mongodbspring.model.Product;
import com.service.mongodbspring.repository.ProductRepository;
import com.service.mongodbspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MongoTemplate template;
    private final BasicMapper mapper;
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public Optional<Product> addProduct(ProductRequest request) {

        Product product = mapper.convertTo(request, Product.class);
        productRepository.findProductByName(request.getName())
                .ifPresentOrElse(name -> {
                    LOGGER.error(String.format("%s already exists", name));
                }, () -> {
                    productRepository.insert(product);
                });

        return productRepository.findProductByName(request.getName());
    }

    private Product addProductToDb(ProductRequest request) {
        return new Product(
                request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getDescription()
        );
    }

    private Product updateProduct(ProductRequest request){
        return null;
    }

    private void implMongoTemplateAndQuery(ProductRepository productRepository,
                                           MongoTemplate template,
                                           String name,
                                           Product product){

    }
}
