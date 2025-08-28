package com.sandy.product.service;

import com.sandy.product.dto.CategoryDTO;
import org.springframework.stereotype.Service;


public interface CategoryService {

    //create category
    public CategoryDTO createCategory(CategoryDTO categoryDTO);

    //get all category
    //get category by id
    //delete category
}
