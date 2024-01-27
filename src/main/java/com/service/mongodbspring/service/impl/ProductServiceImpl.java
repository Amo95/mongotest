package com.service.mongodbspring.service.impl;

import com.mongodb.client.result.UpdateResult;
import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.model.Product;
import com.service.mongodbspring.repository.ProductRepository;
import com.service.mongodbspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MongoTemplate template;

    @Override
    public Product addProduct(ProductRequest request) {

        Query query = new Query();

        query.addCriteria(Criteria.where("name").is(request.getName()));
        List<Product> productList = template.find(query, Product.class);

        if(productList.size() > 1){

        }
        return productRepository.insert(product);
    }

    private Product addProductToDb(ProductRequest request, Query query) {
        return template.upsert(query, )
    }

    private Product updateProduct(ProductRequest request){
        UpdateResult updateResult =
    }
}
