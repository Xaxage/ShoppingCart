package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.dto.CategoryDto;
import com.xaxage.shoppingcart.dto.ProductDto;
import com.xaxage.shoppingcart.model.Category;
import com.xaxage.shoppingcart.model.Product;
import com.xaxage.shoppingcart.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setDescription(categoryDto.getDescription());

        categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> allCategories = categoryRepository.findAll();

        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : allCategories) {
            categoryDtos.add(convertObjectIntoDto(category));
        }

        return categoryDtos;
    }

    @Override
    public void updateCategory(Long categoryId, CategoryDto categoryDto) {
        Category fetchedCategory = categoryRepository.getById(categoryId);
        fetchedCategory.setCategoryName(categoryDto.getCategoryName());
        fetchedCategory.setDescription(categoryDto.getDescription());

        categoryRepository.save(fetchedCategory);
    }

    @Override
    public Optional<Category> findById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public CategoryDto convertObjectIntoDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryName(category.getCategoryName());
        categoryDto.setDescription(category.getDescription());

        return categoryDto;
    }
}
