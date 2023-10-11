package com.ryryanb.shopupspot.service;

import com.ryryanb.shopupspot.model.CustomerOrder;

public interface CustomerOrderService {

	void addCustomerOrder(CustomerOrder customerOrder);
	double getCustomerOrderGrandTotal(Long cartId);
}
