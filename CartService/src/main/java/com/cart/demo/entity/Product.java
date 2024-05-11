package com.cart.demo.entity;

import java.math.BigDecimal;

public class Product {

	private String id;
	private String productName;
	private String description;
	private BigDecimal price;
	private Integer quantity;

	public Product() {
		super();
	}

	public Product(String id, String productName, String description, BigDecimal price, Integer quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
				+ price + ", quantity=" + quantity + "]";
	}

}
