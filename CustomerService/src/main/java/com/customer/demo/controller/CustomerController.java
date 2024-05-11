package com.customer.demo.controller;

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

import com.customer.demo.dto.APIResult;
import com.customer.demo.entity.Customer;
import com.customer.demo.service.CustomerService;

@RestController
@RequestMapping("/api/")
public class CustomerController {

	@Autowired
	private CustomerService userService;

	@GetMapping("/customer")
	public APIResult getAllUsers() {
		APIResult apiResult = new APIResult();
		List<Customer> users = userService.findAll();
		if (users.size() > 0) {
			apiResult.setResult(users);
		} else {
			apiResult.setErrorMsg("result not found.");
		}
		return apiResult;
	}

	@GetMapping("/customer/{id}")
	public APIResult getUserById(@PathVariable String id) {
		APIResult apiResult = new APIResult();
		Customer user = userService.getUserById(id);
		if (user != null) {
			apiResult.setResult(user);
		} else {
			apiResult.setErrorMsg("result not found.");
		}
		return apiResult;
	}

	@PostMapping("/customer")
	public APIResult createUser(@RequestBody Customer user) {
		APIResult apiResult = new APIResult();
		Customer createdUser = userService.createUser(user);
		if (createdUser != null) {
			apiResult.setResult(createdUser);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return apiResult;
	}

	@PutMapping("/customer")
	public APIResult updateUser(@RequestBody Customer userDetails) {
		APIResult apiResult = new APIResult();
		Customer updatedUser = userService.updateUser(userDetails);
		if (updatedUser != null) {
			apiResult.setResult(updatedUser);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return apiResult;
	}

	@DeleteMapping("/customer/{id}")
	public APIResult deleteUser(@PathVariable String id) {
		APIResult apiResult = new APIResult();
		String result = userService.deleteUser(id);
		if (result.equalsIgnoreCase("OK")) {
			apiResult.setResult(HttpStatus.OK);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return apiResult;
	}
}
