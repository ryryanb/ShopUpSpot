package com.ryryanb.shopupspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryryanb.shopupspot.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, String> {

}
