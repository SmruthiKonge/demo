package com.smriti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.smriti.model.BillingAddress;
import com.smriti.model.Customer;
import com.smriti.model.ShippingAddress;
import com.smriti.services.CustomerService;

@Controller
public class RegisterController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/register")
	public String registerCustomer(Model model){
		
	Customer customer=new Customer();
	BillingAddress billingAddress=new BillingAddress();
	ShippingAddress shippingAddress=new ShippingAddress();
	customer.setBillingAddress(billingAddress);
	customer.setShippingAddress(shippingAddress);
	
	model.addAttribute("customer",customer);
	
	return "registerCustomer";
		
		
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerCustomerPost(@ModelAttribute("customer")Customer customer,Model model){
		
		customer.setEnabled(true);
		customerService.addCustomer(customer);
		
		return "registerCustomerSuccess";
	}
	
	
	

}
