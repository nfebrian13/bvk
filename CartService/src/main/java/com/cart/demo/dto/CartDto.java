package com.cart.demo.dto;

public class CartDto {

	private String userId;
	private String productId;
	private Integer quantity;

	public CartDto() {
		super();
	}

	public CartDto(String userId, String productId, Integer quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartDto [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

}
