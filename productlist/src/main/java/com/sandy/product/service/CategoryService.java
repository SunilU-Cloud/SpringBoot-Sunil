package com.sandy.product.service;

import com.sandy.product.dto.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO);

    //get all category
    List<CategoryDTO> getAllCategories();

    //get category by id
    CategoryDTO getCategoryById(Long id);

    String deleteCategory(Long id);


    //delete category
}
