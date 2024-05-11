package com.customer.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.demo.entity.Customer;
import com.customer.demo.service.CustomerService;

@RestController
@RequestMapping("/api/")
public class CustomerController {

	@Autowired
	private CustomerService userService;

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> getAllUsers() {
		List<Customer> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getUserById(@PathVariable String id) {
		Customer user = userService.getUserById(id);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/customer")
	public ResponseEntity<Customer> createUser(@RequestBody Customer user) {
		Customer createdUser = userService.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@PutMapping("/customer")
	public ResponseEntity<Customer> updateUser(@RequestBody Customer userDetails) {
		Customer updatedUser = userService.updateUser(userDetails);
		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
