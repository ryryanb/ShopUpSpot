package com.ryryanb.shopupspot.service;

import java.util.List;

import com.ryryanb.shopupspot.model.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	Product getProductById(String productId);

	void deleteProduct(String productId);
	
	void addProduct(Product product);
	
	void editProduct(Product product);
}
