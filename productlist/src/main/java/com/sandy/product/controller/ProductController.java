package com.sandy.product.controller;

import com.sandy.product.dto.ProductDTO;
import com.sandy.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Product REST API CURD operation",
        description = "CREATE, READ, UPDATE, DELETE, operations for Product REST API"
)
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

   // @Autowired
    private ProductService productService;
    //get all Products

    @Operation(
            summary = "Fetch All Products",
            description = "REST API to fetch all products"
    )
    @GetMapping
    public ResponseEntity<List<ProductDTO>>getAllProducts(){
       List<ProductDTO> products= productService.getAllProducts();
       return new ResponseEntity<>(products,HttpStatus.OK) ;
    }

    //create products
    @Operation(
            summary = "Create Products",
            description = "REST API to create products"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
     @PostMapping
     public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED) ;
     }
    //update product
    @Operation(
            summary = "Update Product By id",
            description = "REST API to update product by id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO>updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id ){
        return new ResponseEntity<>(productService.updateProduct(productDTO,id),HttpStatus.OK);
    }
    //get product by id
    @Operation(
            summary = "Fetch Product By id",
            description = "REST API to fetch product by id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO>getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    // delete product
    @Operation(
            summary = "Delete Products By id",
            description = "REST API to Delete product by id"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.deleteProduct(id),HttpStatus.OK);
    }




}
