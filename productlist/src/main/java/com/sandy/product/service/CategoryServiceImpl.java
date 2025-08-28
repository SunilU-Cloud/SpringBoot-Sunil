package com.sandy.product.service;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.entity.Category;
import com.sandy.product.mapper.CategoryMapper;
import com.sandy.product.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category =CategoryMapper.toCategoryEntity(categoryDTO);
        category=categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }
}
