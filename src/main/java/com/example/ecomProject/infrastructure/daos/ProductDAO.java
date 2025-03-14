package com.example.ecomProject.infrastructure.daos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Table(name = "Product")
@Data
@ApplicationScoped
public class ProductDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productName;
    private String productDescription;
    private int productPrice;
    private String imageFilePath;
    private String productSubCategoryName;
}
