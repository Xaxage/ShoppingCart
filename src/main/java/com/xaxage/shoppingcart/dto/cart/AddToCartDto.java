package com.xaxage.shoppingcart.dto.cart;

import javax.validation.constraints.NotNull;

public class AddToCartDto {

    private Long id;
    private @NotNull Long productId;
    private @NotNull Long quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
