package com.service.mongodbspring.api;

import com.service.mongodbspring.dto.ProductRequest;
import com.service.mongodbspring.dto.ProductResponse;
import com.service.mongodbspring.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("/add/product")
    @Operation(summary = "add product to db", description = "add product to db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully added product"),
            @ApiResponse(responseCode = "404", description = "page not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request){
        return ResponseEntity.ok(productService.addProduct(request));
    }

    @GetMapping("/all/product")
    @Operation(summary = "get all product from db", description = "fetch products from db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched product"),
            @ApiResponse(responseCode = "404", description = "page not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/product/{name}")
    @Operation(summary = "get product by name", description = "fetch product by name from db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched product"),
            @ApiResponse(responseCode = "404", description = "page not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ProductResponse> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProduct(name));
    }

    @DeleteMapping("/product/{name}")
    @Operation(summary = "delete  product from db", description = "delete product from db")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched product"),
            @ApiResponse(responseCode = "404", description = "page not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteProduct(@PathVariable String name){
        productService.RemoveProduct(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
