package com.ryryanb.shopupspot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryryanb.shopupspot.model.Product;
import com.ryryanb.shopupspot.repository.ProductRepository;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;


	@Transactional
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	
	public Product getProductById(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}

	
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
	
	public void addProduct(Product product){
		productRepository.save(product);
	}
	
	public void editProduct(Product product){
		productRepository.save(product);
	}
	
	public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

}
