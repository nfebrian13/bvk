package com.cart.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.cart.demo.entity.Cart;
import com.cart.demo.entity.Product;
import com.cart.demo.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private RestTemplate restTemplate;

	public Cart addCart(String userId, String produkId, Integer quantity) {
		Optional<Cart> optional = cartRepository.findByProductIdAndUserId(userId, produkId);
		Product product = fetchProductfindById(produkId);

		Cart cart;
		if (optional.isPresent()) {
			cart = optional.get();
			if (product != null && product.getQuantity() > (cart.getQuantity() + quantity)) {
				cart.setQuantity(cart.getQuantity() + quantity);
				cart.setSum(new BigDecimal(cart.getPrice().doubleValue() * cart.getQuantity()));
				cartRepository.save(cart);
				
				updateProductQuantity(cart.getProductId(), cart.getQuantity());
			}
		} else {
			cart = new Cart();
			if (product != null && product.getQuantity() > quantity) {
				cart.setId(UUID.randomUUID().toString());
				cart.setProductId(product.getId());
				cart.setQuantity(quantity);
				cart.setPrice(product.getPrice());
				cart.setSum(new BigDecimal(product.getPrice().doubleValue() * quantity));
				cart.setUserId(userId);
				cartRepository.save(cart);
				
				updateProductQuantity(cart.getProductId(), cart.getQuantity());
			}
		}
		return cart;
	}

	public Product fetchProductfindById(String produkId) {
		String url = "http://localhost:9091/api/product/" + produkId;
		ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
		Product responseBody = response.getBody();
		System.out.println(responseBody);
		return responseBody;
	}
	
	public void updateProductQuantity(String produkId, Integer quantity) {
        String url = "http://localhost:9091/api/product/quantity";
        
        Product productParam = new Product();
        productParam.setId(produkId);
        productParam.setQuantity(quantity);
        HttpEntity<Product> requestEntity = new HttpEntity<>(productParam, null);
        ResponseEntity<Product> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Product.class);
        Product responseBody = response.getBody();
		System.out.println(responseBody);
	}

	@Transactional
	public Cart updateQuantity(String userId, String produkId, Integer kuantitas) {
		Optional<Cart> optional = cartRepository.findByProductIdAndUserId(userId, produkId);
		Cart cart = new Cart();
		if (optional.isPresent()) {
			cart = optional.get();
			cart.setQuantity(kuantitas);
			cart.setSum(new BigDecimal(cart.getPrice().doubleValue() * cart.getQuantity()));
			cartRepository.save(cart);
		}
		return cart;
	}

	@Transactional
	public void delete(String userId, String produkId) {
		Optional<Cart> optional = cartRepository.findByProductIdAndUserId(userId, produkId);
		Cart cart = new Cart();
		if (optional.isPresent()) {
			cart = optional.get();
			cartRepository.delete(cart);
		}
	}

	public List<Cart> findByUserId(String userId) {
		return cartRepository.findByUserId(userId);
	}

}
