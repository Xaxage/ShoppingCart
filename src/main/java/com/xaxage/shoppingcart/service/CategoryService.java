package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.dto.CategoryDto;
import com.xaxage.shoppingcart.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    void createCategory(CategoryDto categoryDto);

    List<CategoryDto> getAllCategories();

    void updateCategory(Long categoryId, CategoryDto categoryDto);

    Optional<Category> findById(Long categoryId);
}
