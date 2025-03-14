package com.example.ecomProject.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@SuperBuilder
public class ProductCategory {
    private String name;
    private Long productCategoryId;
    @Builder.Default
    private Set<ProductSubCategory> productSubCategoryList = new HashSet<>();
}
