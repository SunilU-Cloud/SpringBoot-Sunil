package com.sandy.product.service;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.dto.ProductDTO;
import com.sandy.product.entity.Category;
import com.sandy.product.entity.Product;
import com.sandy.product.exception.CategoryNotFoundException;
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

        Category category =categoryRepository.findById(productDTO.getCategoryId())
                 .orElseThrow(()->new CategoryNotFoundException("Category "+ productDTO.getCategoryId()+" not found!"));

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

    @Override
    public ProductDTO getProductById(Long id) {
        Product product=productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found!"));
        return ProductMapper.toProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Long id) {
        Product product=productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found!"));
        Category category=categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()->new RuntimeException("Category not found!"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product "+id+" has been deleted!";
    }


}
