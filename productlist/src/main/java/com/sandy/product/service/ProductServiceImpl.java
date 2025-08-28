package com.sandy.product.service;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

}
