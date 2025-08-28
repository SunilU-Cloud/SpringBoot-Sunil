package com.sandy.product.controller;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.entity.Category;
import com.sandy.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {

  //  @Autowired
    private CategoryService categoryService;

    //get all Category
    @GetMapping
    public ResponseEntity<List<CategoryDTO>>getAllCategories(){
      List<CategoryDTO> categories=categoryService.getAllCategories();
      return new ResponseEntity<>(categories,HttpStatus.OK) ;

    }

    //Create Category
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
         return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    //get by id category
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO>getCategoryById(@PathVariable Long id){
        CategoryDTO categoryDTO=categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }

    //delete category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
      return categoryService.deleteCategory(id);

    }
}
