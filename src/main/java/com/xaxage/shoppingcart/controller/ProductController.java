package com.xaxage.shoppingcart.controller;

import com.xaxage.shoppingcart.api_response.ApiResponse;
import com.xaxage.shoppingcart.dto.ProductDto;
import com.xaxage.shoppingcart.model.Category;
import com.xaxage.shoppingcart.service.CategoryService;
import com.xaxage.shoppingcart.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category hasn't been found!"), HttpStatus.BAD_REQUEST);
        }

        productService.createProduct(productDto, optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true, "Product has been added!"), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable(name = "productId") Long productId,
                                                     @RequestBody ProductDto productDto) throws Exception {

        Optional<Category> optionalCategory = categoryService.findById(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Category hasn't been found!"), HttpStatus.BAD_REQUEST);
        }

        productService.updateProduct(productDto, productId, optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true, "Product has been updated!"), HttpStatus.OK);
    }
}
