package com.example.ecomProject.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class ProductSubCategory {
    private String name;
    private String description;
    private Long productSubCategoryId;
    @Builder.Default
    private List<Product> productList = new ArrayList<>();
}
