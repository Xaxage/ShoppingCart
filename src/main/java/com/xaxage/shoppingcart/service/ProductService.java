package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.dto.ProductDto;
import com.xaxage.shoppingcart.model.Category;
import com.xaxage.shoppingcart.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    void createProduct(ProductDto productDto, Category category);

    List<ProductDto> getAllProducts();

    void updateProduct(ProductDto productDto,Long productId, Category category) throws Exception;

    Product findById(Long productId);
}
