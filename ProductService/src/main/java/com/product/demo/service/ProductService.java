package com.product.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.entity.Product;
import com.product.demo.exception.ResourceNotFoundException;
import com.product.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(String id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("item id: " + id + " can't not found."));
	}

	public Product createItem(Product product) {
		try {
			product.setId(UUID.randomUUID().toString());
			return productRepository.save(product);
		} catch (Exception e) {
			return null;
		}
	}

	public Product updateProduct(Product productDto) {
		Optional<Product> productOptional = productRepository.findById(productDto.getId());
		if (productOptional.isPresent()) {
			Product product = productOptional.get();
			product.setProductName(productDto.getProductName());
			product.setDescription(productDto.getDescription());
			product.setPrice(productDto.getPrice());
			product.setQuantity(productDto.getQuantity());
			return productRepository.save(product);
		} else {
			return null;
		}
	}

	public Product updateQuantityProduct(Product productDto) {
		Optional<Product> productOptional = productRepository.findById(productDto.getId());
		if (productOptional.isPresent()) {
			Product product = productOptional.get();
			product.setProductName(product.getProductName());
			product.setDescription(product.getDescription());
			product.setPrice(product.getPrice());
			product.setQuantity(productDto.getQuantity());
			return productRepository.save(product);
		} else {
			return null;
		}
	}

	public String deleteProduct(String id) {
		try {
			productRepository.deleteById(id);
			return "OK";
		} catch (Exception e) {
			return "FAIL";
		}

	}
}
