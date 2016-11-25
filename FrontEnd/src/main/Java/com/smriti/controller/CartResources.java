package com.smriti.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.smriti.model.Cart;
import com.smriti.model.CartItems;
import com.smriti.model.Customer;
import com.smriti.model.Product;
import com.smriti.services.CartItemService;
import com.smriti.services.CartService;
import com.smriti.services.CustomerService;
import com.smriti.services.ProductService;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@RequestMapping("/{cartId}")
	public @ResponseBody 
	Cart getCartById(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartById(cartId);
	}

	@RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "id") int id, @AuthenticationPrincipal User activeUser) {

		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(id);
		List<CartItems> cartItems = cart.getCartItems();

		for (int i=0; i < cartItems.size(); i++) {
			if (product.getId() == cartItems.get(i).getProduct().getId()) {
				CartItems cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalprice(product.getPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);
			}
		}

		CartItems cartItem = new CartItems();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalprice(product.getPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removeItem(@PathVariable(value = "id") int id) {
		CartItems cartItem = cartItemService.getCartItemById(id);
		cartItemService.removeCartItem(cartItem);
	}

	@RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void clearCart(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request,please verify your payload.")
	public void handleClientErrors(Exception e) {
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Illegal server error.")
	public void handleServerErrors(Exception e) {
	}

}
