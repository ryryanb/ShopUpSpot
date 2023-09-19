package com.ryryanb.shopupspot.service;

import com.ryryanb.shopupspot.model.Cart;
import com.ryryanb.shopupspot.model.CartItem;

public interface CartItemService {

	void addCartItem(CartItem cartItem);
	void removeCartItem(String CartItemId);
	void removeAllCartItems(Cart cart);
}
