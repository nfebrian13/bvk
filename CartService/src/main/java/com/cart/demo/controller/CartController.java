package com.cart.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.demo.dto.APIResult;
import com.cart.demo.dto.CartDto;
import com.cart.demo.entity.Cart;
import com.cart.demo.service.CartService;

@RestController
@RequestMapping("/api")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/cart")
	public APIResult addToCart(@RequestBody CartDto cartDto) {
		APIResult apiResult = new APIResult();
		Cart cart = cartService.addCart(cartDto.getUserId(), cartDto.getProductId(), cartDto.getQuantity());
		if (cart != null) {
			apiResult.setResult(cart);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return apiResult;
	}

	@GetMapping("/cart/{userId}")
	public APIResult findByUserId(@PathVariable String userId) {
		APIResult apiResult = new APIResult();
		List<Cart> cartList = cartService.findByUserId(userId);
		if (cartList.size() > 0) {
			apiResult.setResult(cartList);
		} else {
			apiResult.setErrorMsg("result not found.");
		}
		return apiResult;
	}

	@PutMapping("/cart")
	public APIResult updateQuantity(@RequestBody CartDto cartDto) {
		APIResult apiResult = new APIResult();
		Cart cart = cartService.updateQuantity(cartDto.getUserId(), cartDto.getProductId(), cartDto.getQuantity());
		if (cart != null) {
			apiResult.setResult(cart);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return apiResult;
	}

	@DeleteMapping("/cart")
	public APIResult delete(@RequestBody CartDto cartDto) {
		APIResult apiResult = new APIResult();
		String result = cartService.delete(cartDto.getUserId(), cartDto.getProductId());
		if (result.equalsIgnoreCase("OK")) {
			apiResult.setResult(HttpStatus.OK);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return apiResult;
	}
}
