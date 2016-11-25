package com.smriti.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smriti.dao.ProductDAO;
import com.smriti.model.Product;
import com.smriti.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public Product getProductById(int id){
		return productDAO.getProductById(id);
	}
	
	public List<Product> getProductList(){
		return productDAO.getProductList();
			
	}
	
	public void addProduct(Product product){
		productDAO.addProduct(product);
	}
	
	public void editProduct(Product product){
		productDAO.editProduct(product);
	}
	
	public void deleteProduct(Product product){
		productDAO.deleteProduct(product);
	}
}