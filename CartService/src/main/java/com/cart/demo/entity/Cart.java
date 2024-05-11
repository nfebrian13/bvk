package com.cart.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	private String id;
	private String productId;
	private String userId;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal sum;

	public Cart() {
		super();
	}

	public Cart(String id, String productId, String userId, Integer quantity, BigDecimal price, BigDecimal sum) {
		super();
		this.id = id;
		this.productId = productId;
		this.userId = userId;
		this.quantity = quantity;
		this.price = price;
		this.sum = sum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", productId=" + productId + ", userId=" + userId + ", quantity=" + quantity
				+ ", price=" + price + ", sum=" + sum + "]";
	}

}
