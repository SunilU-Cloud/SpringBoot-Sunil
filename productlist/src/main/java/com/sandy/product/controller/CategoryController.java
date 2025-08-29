package com.sandy.product.controller;

import com.sandy.product.dto.CategoryDTO;
import com.sandy.product.entity.Category;
import com.sandy.product.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Category REST API CURD operation",
        description = "CREATE, READ, UPDATE, DELETE, operations for Category REST API"
)
@RestController
@RequestMapping("api/category")
@AllArgsConstructor
public class CategoryController {

  //  @Autowired
    private CategoryService categoryService;

    //get all Category
    @Operation(
            summary = "Fetch All Category",
            description = "REST API to fetch all category"
    )
    @GetMapping
    public ResponseEntity<List<CategoryDTO>>getAllCategories(){
      List<CategoryDTO> categories=categoryService.getAllCategories();
      return new ResponseEntity<>(categories,HttpStatus.OK) ;

    }

    //Create Category
    @Operation(
            summary = "Create Category",
            description = "REST API to Create category"
    )
    @ApiResponse(
            responseCode = "201",
            description = "CREATED"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
         return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    //get by id category
    @Operation(
            summary = "Fetch Category by id",
            description = "REST API to fetch category by id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO>getCategoryById(@PathVariable Long id){
        CategoryDTO categoryDTO=categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryDTO,HttpStatus.OK);
    }

    //delete category
    @Operation(
            summary = "Delete Category by id",
            description = "REST API to Delete category by id"
    )
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){
      return categoryService.deleteCategory(id);

    }
}
