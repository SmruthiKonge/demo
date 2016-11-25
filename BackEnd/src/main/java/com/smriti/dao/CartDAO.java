package com.smriti.dao;

import com.smriti.model.Cart;

public interface CartDAO {

	/*Cart create(Cart cart);
	
	Cart read(String CartId);
	
	void delete(String CartId);*/
	
	Cart getCartById(int cartId);
	
	void update(Cart cart);
	
	

}
