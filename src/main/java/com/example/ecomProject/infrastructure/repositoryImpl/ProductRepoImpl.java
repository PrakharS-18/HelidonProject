package com.example.ecomProject.infrastructure.repositoryImpl;

import com.example.ecomProject.domain.entity.Product;
import com.example.ecomProject.domain.repository.ProductRepository;
import com.example.ecomProject.infrastructure.daos.ProductSubCategoryDAO;
import com.example.ecomProject.infrastructure.mapper.ProductMapper;
import com.example.ecomProject.infrastructure.utility.JPARepoUtility;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.glassfish.jersey.media.multipart.FormDataParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class ProductRepoImpl implements ProductRepository {

    private final JPARepoUtility jpaRepoUtility;
    private final ProductMapper productMapper;

    @Inject
    public ProductRepoImpl(JPARepoUtility jpaRepoUtility, ProductMapper productMapper) {
        this.jpaRepoUtility = jpaRepoUtility;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return productMapper.daoToDomain(jpaRepoUtility.create(productMapper.domainToDao(product)));
    }
}
