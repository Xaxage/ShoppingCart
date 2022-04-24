package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.dto.cart.AddToCartDto;
import com.xaxage.shoppingcart.dto.cart.CartDto;
import com.xaxage.shoppingcart.model.User;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    void addToCart(AddToCartDto addToCartDto, User user);

    CartDto listCartItems(User user);

    void deleteCartItem(Long cartItemId, User user);
}
