package com.sandy.product.controller;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.entity.Category;
import com.sandy.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {

  //  @Autowired
    private CategoryService categoryService;

    //get all Category

    //Create Category
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
         return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }
    //get by id category 
    //delete category
}
