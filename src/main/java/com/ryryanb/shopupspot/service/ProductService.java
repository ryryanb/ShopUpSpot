package com.ryryanb.shopupspot.service;

import java.util.List;

import com.ryryanb.shopupspot.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	Product getProductById(Long productId);

	void deleteProduct(Long productId);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
	
	List<Product> saveAllProducts(List<Product> products);
}
