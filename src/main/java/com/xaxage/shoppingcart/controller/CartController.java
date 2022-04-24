package com.xaxage.shoppingcart.controller;

import com.xaxage.shoppingcart.api_response.ApiResponse;
import com.xaxage.shoppingcart.dto.cart.AddToCartDto;
import com.xaxage.shoppingcart.dto.cart.CartDto;
import com.xaxage.shoppingcart.model.User;
import com.xaxage.shoppingcart.service.AuthenticationService;
import com.xaxage.shoppingcart.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final AuthenticationService authenticationService;

    public CartController(CartService cartService, AuthenticationService authenticationService) {
        this.cartService = cartService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto,
                                                 @RequestParam("token") String token) {

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);


        cartService.addToCart(addToCartDto, user);

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);

    }

    @GetMapping("/")
    public ResponseEntity<CartDto> getCartItems(@RequestParam("token") String token){
        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        CartDto cartDto = cartService.listCartItems(user);

        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") Long cartItemId,
                                                      @RequestParam("token") String token){
        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        cartService.deleteCartItem(cartItemId,user);

        return new ResponseEntity<>(new ApiResponse(true, "Item removed"), HttpStatus.OK);


    }

}
