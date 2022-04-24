package com.xaxage.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {
    @Column(name = "product_name")
    private @NotNull String productName;
    @Column(name = "description")
    private @NotNull String description;
    @Column(name = "price")
    private @NotNull Double price;
    @Column(name = "count_in_stock")
    private @NotNull Long countInStock;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
