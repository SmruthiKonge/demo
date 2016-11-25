package com.smriti.dao;

import com.smriti.model.Cart;
import com.smriti.model.CartItems;

public interface CartItemDAO {

	void addCartItem(CartItems cartItem);

	void removeCartItem(CartItems cartItem);

	void removeAllCartItems(Cart cart);

	CartItems getCartItemById (int id);
}

