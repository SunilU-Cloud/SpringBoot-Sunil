package com.sandy.product.service;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO>getAllProducts();

    ProductDTO getProductById(Long id);

    ProductDTO updateProduct(ProductDTO productDTO, Long id);

    String deleteProduct(Long id);
}
