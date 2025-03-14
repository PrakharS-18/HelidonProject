package com.example.ecomProject.exposition.dtos;


import com.example.ecomProject.domain.entity.ProductCategory;
import com.example.ecomProject.domain.entity.ProductSubCategory;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@SuperBuilder
@NoArgsConstructor
public class ProductCategoryDTO {

    private String name;
    private Long productCategoryId;
    @Builder.Default
    private Set<ProductSubCategory> productSubCategoryList = new HashSet<>();

    public static ProductCategoryDTO domainToDTO(ProductCategory productCategory) {
        return ProductCategoryDTO.builder()
                .name(productCategory.getName())
                .productSubCategoryList(productCategory.getProductSubCategoryList())
                .build();
    }

    public static ProductCategory dtoToDomain(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(productCategoryDTO.getName());
        productCategory.setProductCategoryId(productCategoryDTO.getProductCategoryId());
        productCategory.setProductSubCategoryList(productCategoryDTO.getProductSubCategoryList());
        return productCategory;
    }
}
