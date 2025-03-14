package com.example.ecomProject.infrastructure.daos;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ProductCategory")
@Data
@NoArgsConstructor
@SuperBuilder
public class ProductCategoryDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productCategoryId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "pcat_id")
    @Builder.Default
    private List<ProductSubCategoryDAO> productSubCategories = new ArrayList<>();


    /* This method is very, very important
     * you need this method because Hibernate will complain about UnsupportedOperation : Immutable Collection
     * Try to find on internet how to add an element to an immutable list and you will get to know the steps in solution automatically
     */

    public void setProductSubCategories(List<ProductSubCategoryDAO> productSubCategories) {
        if (Objects.nonNull(productSubCategories)) {
            if (this.productSubCategories == null) {
                this.productSubCategories = new ArrayList<>();
            }
            else{
                this.productSubCategories.clear();
            }
            this.productSubCategories.addAll(productSubCategories);
        }
        else {
            this.productSubCategories = null;
        }
    }

}
