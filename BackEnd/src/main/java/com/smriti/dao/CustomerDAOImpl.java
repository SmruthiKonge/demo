package com.smriti.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.smriti.model.Authorities;
import com.smriti.model.BillingAddress;
import com.smriti.model.Cart;
import com.smriti.model.Customer;
import com.smriti.model.ShippingAddress;
import com.smriti.model.Users;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	public void addCustomer(Customer customer){
		Session session=sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	BillingAddress billaddr=	customer.getBillingAddress();
	billaddr.setCustomer(customer);
	ShippingAddress shipaddr= customer.getShippingAddress();
		shipaddr.setCustomer(customer);
		session.saveOrUpdate(customer);
		session.saveOrUpdate(billaddr);
		session.saveOrUpdate(shipaddr);
	
		Users newUser= new Users();
		newUser.setUsername(customer.getUsername());
		newUser.setPassword(customer.getPassword());
		newUser.setEnabled(true);
	    newUser.setCustomerId(customer.getCustomerId());
	    
	    Authorities newAuthority=new Authorities();
	    newAuthority.setUsername(customer.getUsername());
	    newAuthority.setAuthority("ROLE_USER");
	    session.save(newUser);
	    session.save(newAuthority);
	    
	    
	    Cart newCart=new Cart();
	    newCart.setCustomer(customer);
	    customer.setCart(newCart);
	    session.saveOrUpdate(customer);
	    session.saveOrUpdate(newCart);
	    tx.commit();
	    session.flush();  
}
	
	public Customer getCustomerById(int customerId){
		Session session=sessionFactory.getCurrentSession();
		return (Customer)session.get(Customer.class, customerId);
	}
	
	public List<Customer>getAllCustomers(){
		Session session=sessionFactory.getCurrentSession();
		Query query =session.createQuery("from Customer");
		List<Customer>customerList=query.list();
		
		
		return customerList;
	}
	
	public Customer getCustomerByUsername(String username){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Customer where username =?");
		query.setString(0, username);
		
		
		return (Customer) query.uniqueResult();
	}

}
