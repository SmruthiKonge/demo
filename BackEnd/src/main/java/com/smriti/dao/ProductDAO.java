package com.smriti.dao;

import java.util.List;

import com.smriti.model.Product;

public interface ProductDAO {

void addProduct(Product product);
	
	void editProduct(Product product);
	
	Product getProductById(int id);
	
	List<Product> getProductList();
	
	void deleteProduct(Product product);
}
