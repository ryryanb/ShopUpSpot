package com.ryryanb.shopupspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryryanb.shopupspot.model.BillingAddress;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {

}
