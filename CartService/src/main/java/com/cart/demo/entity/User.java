package com.cart.demo.entity;

public class User {

	private String id;
	private String nama;
	private String email;

	public User() {
		super();
	}

	public User(String id, String nama, String email) {
		super();
		this.id = id;
		this.nama = nama;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nama=" + nama + ", email=" + email + "]";
	}

}
