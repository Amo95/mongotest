package com.service.mongodbspring.service.impl;

import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.dto.ProductResponse;
import com.service.mongodbspring.mapper.BasicMapper;
import com.service.mongodbspring.model.Product;
import com.service.mongodbspring.repository.ProductRepository;
import com.service.mongodbspring.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MongoTemplate template;
    private final BasicMapper mapper;
    private final static Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public ProductResponse addProduct(ProductRequest request) {

        Query query = new Query().addCriteria(Criteria.where("name").is(request.getName()));
        Update updateDefinition = new Update().set("name", request.getName())
                        .set("price", request.getPrice())
                        .set("quantity", request.getQuantity())
                        .set("description", request.getDescription());
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        return mapper.convertTo(template
                .findAndModify(query, updateDefinition, options, Product.class),
                ProductResponse.class);
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
