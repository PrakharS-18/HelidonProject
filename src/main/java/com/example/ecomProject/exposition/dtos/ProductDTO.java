package com.example.ecomProject.exposition.dtos;


import com.example.ecomProject.domain.entity.Product;
import jakarta.json.JsonObject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.logging.Logger;

@Data
@NoArgsConstructor
@SuperBuilder
public class ProductDTO {
    private String productName;
    private String productDescription;
    private int productPrice;
    private String productSubCategoryName;

    private static final Logger logger = Logger.getLogger(ProductDTO.class.getName());

    public static ProductDTO toDTOFromText(String product) {
        try (Jsonb jsonb = JsonbBuilder.create();) {
            JsonObject jsonObject = jsonb.fromJson(product, JsonObject.class);
            return   ProductDTO.builder()
                    .productDescription(jsonObject.getString("productDescription"))
                    .productName(jsonObject.getString("productName"))
                    .productPrice(jsonObject.getInt("productPrice"))
                    .productSubCategoryName(jsonObject.getString("productSubCategoryName"))
                    .build();
        } catch (Exception e) {
            logger.severe(e.getMessage());
        }
        return new ProductDTO();
    }

    public static Product dtoToDomain(ProductDTO productDTO) {
        return Product.builder()
                .imageFilePath("")
                .productDescription(productDTO.getProductDescription())
                .productName(productDTO.getProductName())
                .productPrice(productDTO.getProductPrice())
                .productSubCategoryName(productDTO.getProductSubCategoryName())
                .build();
    }
}
