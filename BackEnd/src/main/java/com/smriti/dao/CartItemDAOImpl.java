package com.smriti.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smriti.model.Cart;
import com.smriti.model.CartItems;

@Repository
@Transactional
public class CartItemDAOImpl implements CartItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addCartItem(CartItems cartItem){
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	
	}
	
	public void removeCartItem (CartItems cartItem){
		Session session=sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	public void removeAllCartItems(Cart cart){
		List<CartItems> cartItems = cart.getCartItems();
		
		for(CartItems item : cartItems){
			removeCartItem(item);
		}	
		
	}
	
	public CartItems getCartItemById(int id){
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CartItem where id=?");
		query.setInteger(0,id);
		session.flush();
		
		return (CartItems) query.uniqueResult();
		
	}
	
}
