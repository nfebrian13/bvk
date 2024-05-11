package com.order.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.order.demo.dto.Cart;
import com.order.demo.dto.Product;
import com.order.demo.entity.OrderCart;
import com.order.demo.reporsitory.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public OrderCart order(String userId) {
		List<Cart> carts = fetchItemByUserId(userId);
		BigDecimal sumOrder = BigDecimal.ZERO;
		for (Cart cart : carts) {
			sumOrder = sumOrder.add(cart.getSum());

			Product product = fetchProductfindById(cart.getProductId());
			product.setQuantity(product.getQuantity() - cart.getQuantity());
			product.setProductName(product.getProductName());
			product.setDescription(product.getDescription());
			product.setPrice(product.getPrice());
			
			updateProduct(product);
			
			deleteCart(userId, product.getId());
		}
		
		OrderCart order = new OrderCart();
		order.setOrderId(UUID.randomUUID().toString());
		order.setOrderDate(new Date());
		order.setUserId(userId);
		order.setSumOrder(sumOrder);
		orderRepository.save(order);
		
		return order;
	}
	
	public void deleteCart(String userId, String productId) {
        String url = "http://localhost:9092/api/cart";
        
        Cart param = new Cart();
        param.setUserId(userId);
        param.setProductId(productId);
        
        HttpEntity<Cart> requestEntity = new HttpEntity<>(param, null);
        ResponseEntity<Cart> response = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Cart.class);
        Cart responseBody = response.getBody();
		System.out.println(responseBody);
	}
	
	public void updateProduct(Product product) {
        String url = "http://localhost:9091/api/product";
        
        HttpEntity<Product> requestEntity = new HttpEntity<>(product, null);
        ResponseEntity<Product> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Product.class);
        Product responseBody = response.getBody();
		System.out.println(responseBody);
	}

	public List<Cart> fetchItemByUserId(String userId) {
		String url = "http://localhost:9092/api/cart/" + userId;
		ResponseEntity<List<Cart>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Cart>>() {
				});
		List<Cart> responseBody = responseEntity.getBody();
		System.out.println(responseBody);
		return responseBody;
	}

	public Product fetchProductfindById(String produkId) {
		String url = "http://localhost:9091/api/product/" + produkId;
		ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
		Product responseBody = response.getBody();
		System.out.println(responseBody);
		return responseBody;
	}

}
