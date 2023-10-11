package com.ryryanb.shopupspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryryanb.shopupspot.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
