package com.smriti.dao;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.smriti.model.Cart;

@Repository
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	/*private Map<String,Cart> listOfCart;
	
	public CartDAOImpl(){
		
		listOfCart = new HashMap<String, Cart>();
	}
	public Cart create(Cart cart) {
		
		if(listOfCart.keySet().contains(cart.getCartId())){
			throw new IllegalArgumentException(String.format("Cannot create a cart,A cart with the given id(%)" + "already" + "exist" , cart.getCartId()));
			
		}
		listOfCart.put(cart.getCartId(), cart);
		return cart;
	}

	public Cart read(String CartId) {
		return listOfCart.get(CartId);
	}*/

	public void update(Cart cart) {
		/*if(listOfCart.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Cannot update a cart,A cart with the given id(%)" + "dose not" + "exist" , cart.getCartId()));

		}
		listOfCart.put(cartId, cart);*/
		int cartId=cart.getCartId();
	}

	/*public void delete(String cartId) {

		if(!listOfCart.keySet().contains(cartId)){
			throw new IllegalArgumentException(String.format("Cannot delete a cart,A cart with the given id(%)" + "dose not" + "exist" ,cartId));

		}
		listOfCart.remove(cartId);
	
	}*/
	
	public Cart getCartById(int cartId){
		Session session=sessionFactory.getCurrentSession();
		return (Cart) session.get(Cart.class, cartId);
	}

	
}
