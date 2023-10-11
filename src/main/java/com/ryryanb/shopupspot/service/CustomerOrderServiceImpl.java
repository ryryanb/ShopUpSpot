package com.ryryanb.shopupspot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ryryanb.shopupspot.model.Cart;
import com.ryryanb.shopupspot.model.CartItem;
import com.ryryanb.shopupspot.model.CustomerOrder;
import com.ryryanb.shopupspot.repository.CustomerOrderRepository;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

	@Autowired
	private CustomerOrderRepository customerOrderRepository;
	
	private CartService cartService;

    @Autowired
    public void setCartService(@Lazy CartService cartService) {
        this.cartService = cartService;
    }
	
	public void addCustomerOrder(CustomerOrder customerOrder) {
		customerOrderRepository.save(customerOrder);
	}

	public double getCustomerOrderGrandTotal(Long cartId) {
		double grandTotal=0;
		Cart cart = cartService.getCartByCartId(cartId);
		List<CartItem> cartItems = cart.getCartItem();
		
		for(CartItem item: cartItems){
			grandTotal += item.getPrice();
		}
		return grandTotal;
	}

}
