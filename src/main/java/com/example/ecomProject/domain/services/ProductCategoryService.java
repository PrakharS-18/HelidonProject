package com.example.ecomProject.domain.services;

import com.example.ecomProject.domain.entity.ProductCategory;
import com.example.ecomProject.domain.repository.ProductCategoryRepository;
import com.example.ecomProject.infrastructure.mapper.ProductCategoryMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProductCategoryService {

    private final ProductCategoryRepository pcRepo;

    @Inject
    public ProductCategoryService(ProductCategoryRepository pcRepo) {
        this.pcRepo = pcRepo;
    }

    public List<ProductCategory> getAllProductCategory() {
        return pcRepo.getAllProductCategory();
    }

    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return pcRepo.createProductCategory(productCategory);
    }

    public ProductCategory deleteProductCategory(String name) {
        return pcRepo.deleteProductCategory(name);
    }

    public ProductCategory updateProductCategory(String name, ProductCategory productCategory) {
        return pcRepo.updateProductCategory(name, productCategory);
    }
}
