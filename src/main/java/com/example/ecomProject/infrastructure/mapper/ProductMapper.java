package com.example.ecomProject.infrastructure.mapper;

import com.example.ecomProject.domain.entity.Product;
import com.example.ecomProject.infrastructure.daos.ProductDAO;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Data;

@ApplicationScoped
@Data
public class ProductMapper {

    public Product daoToDomain(ProductDAO productDAO) {
        return Product.builder()
                .productName(productDAO.getProductName())
                .productPrice(productDAO.getProductPrice())
                .productDescription(productDAO.getProductDescription())
                .imageFilePath(productDAO.getImageFilePath())
                .productId(productDAO.getProductId())
                .build();
    }

    public ProductDAO domainToDao(Product product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.setProductName(product.getProductName());
        productDAO.setProductDescription(product.getProductDescription());
        productDAO.setProductPrice(product.getProductPrice());
        productDAO.setImageFilePath(product.getImageFilePath());
        productDAO.setProductSubCategoryName(product.getProductSubCategoryName());
        return productDAO;
    }
}
