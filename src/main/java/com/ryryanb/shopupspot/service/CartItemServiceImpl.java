package com.ryryanb.shopupspot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryryanb.shopupspot.model.Cart;
import com.ryryanb.shopupspot.model.CartItem;
import com.ryryanb.shopupspot.repository.CartItemRepository;
import com.ryryanb.shopupspot.repository.CartRepository;

import jakarta.transaction.Transactional;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemRepository cartItemRepository;

	public void addCartItem(CartItem cartItem) {
		cartItemRepository.save(cartItem);
	}
	
	@Transactional
    public void removeCartItem(Long cartItemId) {
        // Find the cart item by its ID
        CartItem cartItem = cartItemRepository.findById(cartItemId).orElse(null);

        if (cartItem != null) {
            // Remove the cart item from the cart
            Cart cart = cartItem.getCart();
            cart.getCartItem().remove(cartItem);

            // Delete the cart item from the database
            cartItemRepository.delete(cartItem);
        }
    }

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems = cart.getCartItem();
		for (CartItem cartItem : cartItems) {
			removeCartItem(cartItem.getCartItemId());
		}
	}

}
