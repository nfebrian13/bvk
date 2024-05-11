package com.order.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderCart {
	@Id
	private String orderId;
	private Date orderDate;
	private String userId;
	private BigDecimal sumOrder;

	public OrderCart() {
		super();
	}

	public OrderCart(String orderId, Date orderDate, String userId, BigDecimal sumOrder) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.userId = userId;
		this.sumOrder = sumOrder;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getSumOrder() {
		return sumOrder;
	}

	public void setSumOrder(BigDecimal sumOrder) {
		this.sumOrder = sumOrder;
	}

	@Override
	public String toString() {
		return "OrderCart [orderId=" + orderId + ", orderDate=" + orderDate + ", userId=" + userId + ", sumOrder="
				+ sumOrder + "]";
	}

}
