package com.ryryanb.shopupspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryryanb.shopupspot.model.ShippingAddress;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, String> {


}

