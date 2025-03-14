package com.example.ecomProject.domain.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Product {
    private Long productId;
    private String productName;
    private String productDescription;
    private int productPrice;
    private String productSubCategoryName;
    private String imageFilePath;
}
