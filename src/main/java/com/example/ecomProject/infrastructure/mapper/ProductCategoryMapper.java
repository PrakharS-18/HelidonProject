package com.example.ecomProject.infrastructure.mapper;

import com.example.ecomProject.domain.entity.ProductCategory;
import com.example.ecomProject.infrastructure.daos.ProductCategoryDAO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.java.Log;

import java.util.stream.Collectors;

@ApplicationScoped
@Log
public class ProductCategoryMapper {

    private final ProductSubCategoryMapper pscMapper;

    @Inject
    public ProductCategoryMapper(ProductSubCategoryMapper pscMapper) {
        this.pscMapper = pscMapper;
    }

    public ProductCategory daoToDomain(ProductCategoryDAO productCategoryDAO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setProductCategoryId(productCategoryDAO.getProductCategoryId());
        productCategory.setName(productCategoryDAO.getName());
        productCategory.setProductSubCategoryList(productCategoryDAO.getProductSubCategories()
                                                                    .stream()
                                                                    .map(pscMapper::daoToDomain)
                                                                    .collect(Collectors.toSet()));
        return productCategory;
    }

    public ProductCategoryDAO domainToDao(ProductCategory productCategory) {
        ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();
        productCategoryDAO.setName(productCategory.getName());
        productCategoryDAO.setProductSubCategories(productCategory.getProductSubCategoryList().stream()
                .map(pscMapper::domainToDao)
                .toList());
        return productCategoryDAO;
    }
}
