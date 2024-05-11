package com.product.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.entity.Product;
import com.product.demo.service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	private ProductService itemService;

	@GetMapping("/product")
	public List<Product> findAll() {
		return itemService.findAll();
	}

	@GetMapping("/product/{id}")
	public Product findById(@PathVariable("id") String id) {
		return itemService.findById(id);
	}

	@PostMapping("/product")
	public Product createItem(@RequestBody Product product) {
		return itemService.createItem(product);
	}

	@PutMapping("/product")
	public Product updateItem(@RequestBody Product product) {
		return itemService.updateProduct(product);
	}

	@PutMapping("/product/quantity")
	public Product updateQuantityProduct(@RequestBody Product product) {
		return itemService.updateQuantityProduct(product);
	}

	@DeleteMapping("/product/{id}")
	public void deleteItemById(@PathVariable("id") String id) {
		itemService.deleteProduct(id);
	}

}
