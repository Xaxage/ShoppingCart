package com.xaxage.shoppingcart.dto.cart;

import java.util.List;

public class CartDto {
    private List<CartItemDto> cartItems;
    private Double totalCost;

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
