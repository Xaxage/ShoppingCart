package com.xaxage.shoppingcart.repository;

import com.xaxage.shoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
