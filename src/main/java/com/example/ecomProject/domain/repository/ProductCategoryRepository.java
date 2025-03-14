package com.example.ecomProject.domain.repository;

import com.example.ecomProject.domain.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryRepository {

    List<ProductCategory> getAllProductCategory();

    ProductCategory createProductCategory(ProductCategory productCategory);

    ProductCategory deleteProductCategory(String name);

    ProductCategory updateProductCategory(String name,ProductCategory productCategory);
}
