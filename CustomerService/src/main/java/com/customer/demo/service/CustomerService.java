package com.customer.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.demo.entity.Customer;
import com.customer.demo.exception.ResourceNotFoundException;
import com.customer.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	public Customer getUserById(String id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("item id: " + id + " can't not found."));
	}

	public Customer createUser(Customer user) {
		user.setId(UUID.randomUUID().toString());
		return customerRepository.save(user);
	}

	public Customer updateUser(Customer userDto) {
		Optional<Customer> userOptional = customerRepository.findById(userDto.getId());
		if (userOptional.isPresent()) {
			Customer user = userOptional.get();
			user.setName(userDto.getName());
			user.setEmail(userDto.getEmail());
			return customerRepository.save(user);
		} else {
			return null;
		}
	}

	public void deleteUser(String id) {
		customerRepository.deleteById(id);
	}
}
