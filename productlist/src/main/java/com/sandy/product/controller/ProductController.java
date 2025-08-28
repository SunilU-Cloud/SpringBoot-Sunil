package com.sandy.product.controller;

import com.sandy.product.dto.ProductDTO;
import com.sandy.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

   // @Autowired
    private ProductService productService;
    //get all Products
    @GetMapping
    public ResponseEntity<List<ProductDTO>>getAllProducts(){
       List<ProductDTO> products= productService.getAllProducts();
       return new ResponseEntity<>(products,HttpStatus.OK) ;
    }

    //create products
      @PostMapping
     public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED) ;
     }
    //update product
    //get product by id
    // delete product

}
