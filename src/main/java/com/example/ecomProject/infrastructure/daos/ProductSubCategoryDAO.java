package com.example.ecomProject.infrastructure.daos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ProductSubCategory")
@SuperBuilder
@NoArgsConstructor
@Data
public class ProductSubCategoryDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productSubCategoryId;
    private String productSubCategoryName;
    private String productSubCategoryDescription;

}
