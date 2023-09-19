package com.ryryanb.shopupspot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryryanb.shopupspot.model.Authorities;
import com.ryryanb.shopupspot.model.Cart;
import com.ryryanb.shopupspot.model.Customer;
import com.ryryanb.shopupspot.model.User;
import com.ryryanb.shopupspot.repository.CustomerRepository;
import com.ryryanb.shopupspot.repository.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserRepository userRepository;

	// The database transaction happens inside the scope of a persistence
	// context. The persistence context is in JPA the EntityManager ,
	// implemented internally using an Hibernate Session (when using Hibernate
	// as the persistence provider).

	@Transactional
	public void addCustomer(Customer customer) {
		System.out.println("Adding customer in dao");
		//customer - has users,shippingaddress
		//insert the users,billingaddress
		customer.getUsers().setEnabled(true);
		
		Authorities authorities = new Authorities();
		authorities.setAuthorities("ROLE_USER");
		authorities.setEmailId(customer.getUsers().getEmailId());
		
		Cart cart = new Cart();
		//it is to set CartId for customer table
		customer.setCart(cart);//set the cart to the customer
		//if we omit this statement, hen it will insert null for customerid in cart
		//to set the customerid in cart table
		cart.setCustomer(customer);
		customerRepository.save(customer);

	}

	public List<Customer> getAllCustomers() {
List<Customer> customerList = customerRepository.findAll();
		
		return customerList;

		
	}

	public Customer getCustomerByemailId(String emailId) {
		User user = userRepository.getUserByEmailId(emailId);
		Customer customer = customerRepository.getCustomerByUsers(user);
		return customer;
	}

}
