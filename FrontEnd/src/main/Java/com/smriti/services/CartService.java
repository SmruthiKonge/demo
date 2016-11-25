package com.smriti.services;

import com.smriti.model.Cart;

public interface CartService {

	
	Cart getCartById(int cartId);
	
	void update(Cart cart);
}