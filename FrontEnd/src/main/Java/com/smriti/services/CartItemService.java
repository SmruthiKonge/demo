package com.smriti.services;

import com.smriti.model.Cart;
import com.smriti.model.CartItems;

public interface CartItemService {
	
	
	void addCartItem(CartItems cartItem);
	
	void removeCartItem(CartItems cartItem);
	
	void removeAllCartItems(Cart cart);
	
	CartItems getCartItemById (int id);

}
