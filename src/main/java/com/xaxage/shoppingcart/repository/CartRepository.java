package com.xaxage.shoppingcart.repository;

import com.xaxage.shoppingcart.model.Cart;
import com.xaxage.shoppingcart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
