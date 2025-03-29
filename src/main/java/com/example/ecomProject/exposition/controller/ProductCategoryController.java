package com.example.ecomProject.exposition.controller;

import com.example.ecomProject.domain.entity.ProductCategory;
import com.example.ecomProject.domain.services.ProductCategoryService;
import com.example.ecomProject.exposition.dtos.ProductCategoryDTO;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.java.Log;

import java.util.List;
import java.util.logging.Logger;

@Path("/productCategory")
public class ProductCategoryController {

    private static final Logger log = Logger.getLogger(ProductCategoryController.class.getName());

    private final ProductCategoryService pcService;

    @Inject
    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.pcService = productCategoryService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<ProductCategory> getAllProductCategory() {
        log.info("getAllProductCategory");
        return pcService.getAllProductCategory();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public ProductCategory createProductCategory(ProductCategoryDTO productCategoryDTO) {
        log.info("createProductCategory");
        return pcService.createProductCategory(ProductCategoryDTO.dtoToDomain(productCategoryDTO));
    }

    @PUT
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public ProductCategory updateProductCategory(@Valid ProductCategoryDTO productCategoryDTO, @PathParam("name") String name) {
        log.info("updateProductCategory");
        return pcService.updateProductCategory(name, ProductCategoryDTO.dtoToDomain(productCategoryDTO));
    }

    @DELETE
    @Path("/{name}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public ProductCategory deleteProductCategory(@PathParam("name") String name) {
        log.info("deleteProductCategory");
        return pcService.deleteProductCategory(name);
    }


}
