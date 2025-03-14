package com.example.ecomProject.domain.services;


import com.example.ecomProject.domain.entity.Product;
import com.example.ecomProject.domain.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

@Slf4j
@ApplicationScoped
public class ProductService {

    private final ProductRepository productRepository;
    private static final Logger logger = Logger.getLogger(ProductService.class.getName());

    @Inject
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product, FormDataBodyPart formDataParam) {
        product.setImageFilePath(saveImage(formDataParam));
        return productRepository.createProduct(product);
    }

    public String saveImage(FormDataBodyPart formDataParam) {
        String imageName = formDataParam.getFileName().toString();
        String uploadedImagePath = "";
        try {
            Path uploadFileBasePath = Path.of(System.getProperty("user.home"), "upload");
            if (!Files.exists(uploadFileBasePath)) {
                Files.createDirectory(uploadFileBasePath);
            }
            Path imagePath = uploadFileBasePath.resolve(imageName);
            byte[] imageBytes = formDataParam.getContent().readAllBytes();
            Files.write(imagePath, imageBytes);
            uploadedImagePath = imagePath.toString();
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        logger.info("File uploaded successfully to: " + uploadedImagePath);
        return uploadedImagePath;
    }
}
