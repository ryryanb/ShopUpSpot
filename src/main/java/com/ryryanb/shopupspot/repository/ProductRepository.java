package com.ryryanb.shopupspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryryanb.shopupspot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
