package com.example.ecomProject.exposition.controller;

import com.example.ecomProject.domain.entity.Product;
import com.example.ecomProject.domain.services.ProductService;
import com.example.ecomProject.exposition.dtos.ProductDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/product")
public class ProductController {

    private final ProductService productService;

    @Inject
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Product createProduct(@FormDataParam("product") String product, @FormDataParam("productImage") FormDataBodyPart formDataParam) {
        return productService.createProduct(ProductDTO.dtoToDomain(ProductDTO.toDTOFromText(product)), formDataParam);
    }
}
