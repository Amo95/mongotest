package com.service.mongodbspring.service.impl;

import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.dto.ProductResponse;
import com.service.mongodbspring.mapper.BasicMapper;
import com.service.mongodbspring.model.Image;
import com.service.mongodbspring.model.Product;
import com.service.mongodbspring.repository.ProductRepository;
import com.service.mongodbspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final BasicMapper basicMapper;

    @Override
    public ProductResponse addProduct(ProductRequest request) {
        Product product = basicMapper.convertTo(request, Product.class);
        return basicMapper.convertTo(addProductToDb(product), ProductResponse.class);
    }

    private Product addProductToDb(Product product) {
//        product.setImage(new Image().setImageLocation("loca"););
        return productRepository.insert(product);
    }
}
