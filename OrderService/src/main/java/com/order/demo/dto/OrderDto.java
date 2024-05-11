package com.order.demo.dto;

public class OrderDto {

	private String userId;

	public OrderDto() {
		super();
	}

	public OrderDto(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "OrderDto [userId=" + userId + "]";
	}

}
