package com.cart.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.demo.dto.CartDto;
import com.cart.demo.entity.Cart;
import com.cart.demo.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/cart")
	public Cart addToCart(@RequestBody CartDto cartDto) {
		return cartService.addCart(cartDto.getUserId(), cartDto.getProductId(), cartDto.getQuantity());
	}

	@GetMapping("/cart/{userId}")
	public List<Cart> findByUserId(@PathVariable String userId) {
		return cartService.findByUserId(userId);
	}

	@PutMapping("/cart")
	public Cart updateQuantity(@RequestBody CartDto cartDto) {
		return cartService.updateQuantity(cartDto.getUserId(), cartDto.getProductId(), cartDto.getQuantity());
	}

	@DeleteMapping("/cart")
	public void delete(@RequestBody CartDto cartDto) {
		cartService.delete(cartDto.getUserId(), cartDto.getProductId());
	}
}
