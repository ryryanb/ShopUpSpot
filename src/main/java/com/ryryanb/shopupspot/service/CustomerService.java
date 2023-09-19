package com.ryryanb.shopupspot.service;

import java.util.List;

import com.ryryanb.shopupspot.model.Customer;

public interface CustomerService {

	void addCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerByemailId(String emailId);

}
