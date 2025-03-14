package com.example.ecomProject.infrastructure.repositoryImpl;

import com.example.ecomProject.domain.entity.ProductCategory;
import com.example.ecomProject.domain.repository.ProductCategoryRepository;
import com.example.ecomProject.exposition.dtos.ProductCategoryDTO;
import com.example.ecomProject.infrastructure.daos.ProductCategoryDAO;
import com.example.ecomProject.infrastructure.mapper.ProductCategoryMapper;
import com.example.ecomProject.infrastructure.mapper.ProductSubCategoryMapper;
import com.example.ecomProject.infrastructure.utility.JPARepoUtility;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductCategoryRepoImpl implements ProductCategoryRepository {

    private final JPARepoUtility jpaRepoUtility;
    private final ProductCategoryMapper pcMapper;
    private final ProductSubCategoryMapper pscMapper;

    @Inject
    public ProductCategoryRepoImpl(JPARepoUtility jpaRepoUtility, ProductCategoryMapper pcMapper, ProductSubCategoryMapper pscMapper) {
        this.jpaRepoUtility = jpaRepoUtility;
        this.pcMapper = pcMapper;
        this.pscMapper = pscMapper;
    }

    @Override
    public List<ProductCategory> getAllProductCategory() {
        return jpaRepoUtility.getElementByFields(ProductCategoryDAO.class, new HashMap<>()).stream()
                .map(pcMapper::daoToDomain)
                .toList();
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return pcMapper.daoToDomain(jpaRepoUtility.create(pcMapper.domainToDao(productCategory)));
    }

    @Override
    public ProductCategory deleteProductCategory(String name) {
        Map<String, String> fields = new HashMap<>();
        fields.put("name", name);
        ProductCategoryDAO pcDAOByName = jpaRepoUtility.getElementByFields(ProductCategoryDAO.class, fields).getFirst();
        return pcMapper.daoToDomain(jpaRepoUtility.remove(pcDAOByName));
    }

    @Override
    public ProductCategory updateProductCategory(String name,ProductCategory productCategory) {
        Map<String, String> fields = Map.of("name", name);
        ProductCategoryDAO pcDAOByName = jpaRepoUtility.getElementByFields(ProductCategoryDAO.class, fields).getFirst();
        pcDAOByName.setProductSubCategories(productCategory.getProductSubCategoryList().stream()
                .map(pscMapper::toDAOWhileUpdate)
                .toList());
        return pcMapper.daoToDomain(jpaRepoUtility.update(pcDAOByName));
    }

}
