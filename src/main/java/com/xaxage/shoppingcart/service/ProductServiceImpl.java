package com.xaxage.shoppingcart.service;

import com.xaxage.shoppingcart.dto.ProductDto;
import com.xaxage.shoppingcart.exception.ProductNotExistsException;
import com.xaxage.shoppingcart.model.Category;
import com.xaxage.shoppingcart.model.Product;
import com.xaxage.shoppingcart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCountInStock(productDto.getCountInStock());
        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();

        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : allProducts) {
            productDtos.add(convertObjectIntoDto(product));
        }

        return productDtos;
    }

    @Override
    public void updateProduct(ProductDto productDto, Long productId, Category category) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (!optionalProduct.isPresent()) {
            throw new Exception("Product hasn't been found!");
        }

        Product product = optionalProduct.get();

        product.setProductName(productDto.getProductName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCountInStock(productDto.getCountInStock());
        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    public Product findById(Long productId) throws ProductNotExistsException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotExistsException("Invalid product" + productId);
        }
        return optionalProduct.get();
    }

    private ProductDto convertObjectIntoDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setProductName(product.getProductName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCountInStock(product.getCountInStock());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setId(product.getId());

        return productDto;
    }
}
