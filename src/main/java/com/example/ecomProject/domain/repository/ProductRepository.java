package com.example.ecomProject.domain.repository;

import com.example.ecomProject.domain.entity.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> getAllProducts();

    Product createProduct(Product product);
}
