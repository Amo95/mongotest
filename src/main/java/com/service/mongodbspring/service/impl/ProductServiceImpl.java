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

import java.util.List;

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
                        .set("description", request.getDescription())
                .set("color", request.getColor());
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true).upsert(true);

        return mapper.convertTo(template
                .findAndModify(query, updateDefinition, options, Product.class),
                ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return mapper.convertListTo(productRepository.findAll(), ProductResponse.class);
    }

    @Override
    public ProductResponse getProduct(String name) {
        return mapper.convertTo(productRepository.findProductByName(name), ProductResponse.class);
    }

    @Override
    public void RemoveProduct(String name) {
        productRepository.deleteByName(name);
    }

    private Product addProductToDb(ProductRequest request) {
        return new Product(
                request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getDescription(),
                request.getColor()
        );
    }
}
