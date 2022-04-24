package com.xaxage.shoppingcart.controller;

import com.xaxage.shoppingcart.api_response.ApiResponse;
import com.xaxage.shoppingcart.dto.CategoryDto;
import com.xaxage.shoppingcart.dto.ProductDto;
import com.xaxage.shoppingcart.model.Category;
import com.xaxage.shoppingcart.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(new ApiResponse(true, "Category has been added!"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
//        return categoryService.getAllCategories();
        List<CategoryDto> products = categoryService.getAllCategories();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") Long categoryId, @RequestBody CategoryDto categoryDto) {

        if (categoryService.findById(categoryId).isEmpty()) {
            return new ResponseEntity<>(new ApiResponse(false, "Category hasn't been found!"), HttpStatus.NOT_FOUND);
        }

        categoryService.updateCategory(categoryId, categoryDto);
        return new ResponseEntity<>(new ApiResponse(true, "Category has been updated!"), HttpStatus.OK);
    }
}
