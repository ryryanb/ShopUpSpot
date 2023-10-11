package com.ryryanb.shopupspot.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class ProductImageService {
    private final ResourceLoader resourceLoader;

    public ProductImageService(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Resource getProductImageResource(long productId) throws IOException {
        String imagePath = "static/resource/images/" + productId + ".jpg";
        Resource resource = resourceLoader.getResource("classpath:" + imagePath);

        if (resource.exists() && resource.isReadable()) {
            return resource;
        } else {
            throw new IOException("Product image not found for productId: " + productId);
        }
    }
}
