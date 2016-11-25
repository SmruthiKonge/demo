package com.smriti.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smriti.dao.CartDAO;
import com.smriti.model.Cart;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	public Cart getCartById(int cartId){
		return cartDAO.getCartById(cartId);
		
		
	}
	
	public void update(Cart cart){
		cartDAO.update(cart);
	}

}

