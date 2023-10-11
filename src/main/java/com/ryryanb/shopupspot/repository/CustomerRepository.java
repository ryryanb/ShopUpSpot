package com.ryryanb.shopupspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryryanb.shopupspot.model.Customer;
import com.ryryanb.shopupspot.model.User;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer getCustomerByUsers(User user);
}
