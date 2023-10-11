package com.ryryanb.shopupspot.temp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.ryryanb.shopupspot.model.Product;
import com.ryryanb.shopupspot.service.ProductService;

import jakarta.annotation.PostConstruct;

@Service
public class ProductInitializationService {

    private final ProductService productService;

    @Autowired
    public ProductInitializationService(ProductService productService) {
        this.productService = productService;
    }

    @PostConstruct
    public void initializeProducts() {
        // Create and save 5 Product records using Faker
        List<Product> products = generateFakeProducts(5);
        productService.saveAllProducts(products);
    }

    // Helper method to generate fake Product records
    private List<Product> generateFakeProducts(int numberOfProducts) {
        List<Product> products = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < numberOfProducts; i++) {
            Product product = new Product();
            product.setProductCategory(faker.commerce().department());
            product.setProductDescription(faker.lorem().sentence());
            product.setProductManufacturer(faker.company().name());
            product.setProductName(faker.commerce().productName());
            product.setProductPrice(faker.number().randomDouble(2, 100, 1000));
            product.setUnitStock(faker.number().numberBetween(1, 100));
            
            products.add(product);
        }

        return products;
    }
}
