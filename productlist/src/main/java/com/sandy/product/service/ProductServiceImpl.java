package com.sandy.product.service;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.dto.ProductDTO;
import com.sandy.product.entity.Category;
import com.sandy.product.entity.Product;
import com.sandy.product.mapper.ProductMapper;
import com.sandy.product.repository.CategoryRepository;
import com.sandy.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

   // @Autowired
    private ProductRepository productRepository;

   // @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        /**
         *   id , name , description , price, categoryId
         * **/
        Category category =categoryRepository.findById(productDTO.getCategoryId())
                 .orElseThrow(()->new RuntimeException("Category not found!"));

        //DTO -> Entity
        Product product =ProductMapper.toProductEntity(productDTO,category);
        product=productRepository.save(product);

        //Entity -> DTO
        return ProductMapper.toProductDTO(product);

    }

    @Override
    public List<ProductDTO> getAllProducts() {
         return productRepository.findAll().stream().map(ProductMapper::toProductDTO).toList();

    }


}
