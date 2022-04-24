package com.xaxage.shoppingcart.dto;

import javax.validation.constraints.NotNull;

public class ProductDto {
    private Long id;
    private @NotNull String productName;
    private @NotNull String description;
    private @NotNull Double price;
    private @NotNull Long countInStock;
    private @NotNull Long categoryId;

    public ProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getCountInStock() {
        return countInStock;
    }

    public void setCountInStock(Long countInStock) {
        this.countInStock = countInStock;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
