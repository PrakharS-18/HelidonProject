package com.example.ecomProject.infrastructure.repositoryImpl;

import com.example.ecomProject.domain.entity.ProductSubCategory;
import com.example.ecomProject.domain.repository.ProductSubCategoryRepository;

import java.util.List;

public class ProductSubCatRepoImpl implements ProductSubCategoryRepository {
    @Override
    public List<ProductSubCategory> getAllProductSubCategories() {
        return List.of();
    }
}
