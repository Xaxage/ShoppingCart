package com.xaxage.shoppingcart.dto;

import javax.validation.constraints.NotBlank;

public class CategoryDto {
    private Long id;

    private @NotBlank String categoryName;

    private @NotBlank String description;


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
