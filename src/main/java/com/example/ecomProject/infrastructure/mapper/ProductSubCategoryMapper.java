package com.example.ecomProject.infrastructure.mapper;

import com.example.ecomProject.domain.entity.ProductSubCategory;
import com.example.ecomProject.infrastructure.daos.ProductCategoryDAO;
import com.example.ecomProject.infrastructure.daos.ProductSubCategoryDAO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductSubCategoryMapper {

    public ProductSubCategory daoToDomain(ProductSubCategoryDAO productSubCategoryDAO) {
        ProductSubCategory productSubCategory = new ProductSubCategory();
        productSubCategory.setProductSubCategoryId(productSubCategoryDAO.getProductSubCategoryId());
        productSubCategory.setName(productSubCategoryDAO.getProductSubCategoryName());
        productSubCategory.setDescription(productSubCategoryDAO.getProductSubCategoryDescription());
        return productSubCategory;
    }

    public ProductSubCategoryDAO domainToDao(ProductSubCategory productSubCategory) {
        ProductSubCategoryDAO productSubCategoryDAO = new ProductSubCategoryDAO();
        productSubCategoryDAO.setProductSubCategoryDescription(productSubCategory.getDescription());
        productSubCategoryDAO.setProductSubCategoryName(productSubCategory.getName());
        return productSubCategoryDAO;

    }

    public ProductSubCategoryDAO toDAOWhileUpdate(ProductSubCategory productSubCategory) {
        ProductSubCategoryDAO productSubCategoryDAO = new ProductSubCategoryDAO();
        productSubCategoryDAO.setProductSubCategoryDescription(productSubCategory.getDescription());
        productSubCategoryDAO.setProductSubCategoryName(productSubCategory.getName());
        productSubCategoryDAO.setProductSubCategoryId(productSubCategory.getProductSubCategoryId());
        return productSubCategoryDAO;
    }

}
