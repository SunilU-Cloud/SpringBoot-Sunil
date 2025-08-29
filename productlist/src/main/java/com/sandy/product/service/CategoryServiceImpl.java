package com.sandy.product.service;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.entity.Category;
import com.sandy.product.exception.CategoryAlreadyExistsException;
import com.sandy.product.mapper.CategoryMapper;
import com.sandy.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Optional<Category>optionalCategory =categoryRepository.findByName(categoryDTO.getName());
        if (optionalCategory.isPresent()){
            throw new CategoryAlreadyExistsException("Category "+ categoryDTO.getName() +" already exists!");
        }
        Category category =CategoryMapper.toCategoryEntity(categoryDTO);
        category=categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return  categoryRepository.findAll().stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
         Category category=categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
         return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category "+ id +" has been deleted!";
    }
}
