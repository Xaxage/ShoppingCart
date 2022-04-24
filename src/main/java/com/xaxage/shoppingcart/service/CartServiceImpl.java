package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.dto.cart.AddToCartDto;
import com.xaxage.shoppingcart.dto.cart.CartDto;
import com.xaxage.shoppingcart.dto.cart.CartItemDto;
import com.xaxage.shoppingcart.exception.CustomException;
import com.xaxage.shoppingcart.model.Cart;
import com.xaxage.shoppingcart.model.Product;
import com.xaxage.shoppingcart.model.User;
import com.xaxage.shoppingcart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    private final ProductService productService;
    private final CartRepository cartRepository;

    public CartServiceImpl(ProductService productService, CartRepository cartRepository) {
        this.productService = productService;
        this.cartRepository = cartRepository;
    }

    @Override
    public void addToCart(AddToCartDto addToCartDto, User user) {
        Product product = productService.findById(addToCartDto.getProductId());

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDto.getQuantity());

        cartRepository.save(cart);
    }

    @Override
    public CartDto listCartItems(User user) {
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

        List<CartItemDto> cartItemDtos = new ArrayList<>();

        Double totalCost = 0.0;

        for (Cart cart : cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            cartItemDtos.add(cartItemDto);
            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
        }

        CartDto cartDto = new CartDto();
        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItemDtos);

        return cartDto;
    }

    @Override
    public void deleteCartItem(Long cartItemId, User user) {
        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);
        if (optionalCart.isEmpty()) {
            throw new CustomException("Cart item id" + cartItemId + "wasn't found!");
        }

        Cart cart = optionalCart.get();

        if(cart.getUser() != user){
            throw new CustomException("Cart item doesn't belong to user:" + cartItemId);
        }

        cartRepository.delete(cart);
    }
}
