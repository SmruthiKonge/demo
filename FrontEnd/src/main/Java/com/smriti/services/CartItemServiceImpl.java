package com.smriti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smriti.dao.CartItemDAO;
import com.smriti.model.Cart;
import com.smriti.model.CartItems;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	
	@Autowired
	private CartItemDAO cartItemDAO;
	
	public void addCartItem(CartItems cartItem){
		cartItemDAO.addCartItem(cartItem);
		
	}
	public void removeCartItem(CartItems cartItem){
		cartItemDAO.removeCartItem(cartItem);
	}
	public void removeAllCartItems(Cart cart){
		cartItemDAO.removeAllCartItems(cart);
	}
	
	public CartItems getCartItemById(int id){
		return cartItemDAO.getCartItemById(id);
		
	}
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		
	}

}
