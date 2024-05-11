package com.product.demo.controller;

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

import com.product.demo.dto.APIResult;
import com.product.demo.entity.Product;
import com.product.demo.service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	private ProductService itemService;

	@GetMapping("/product")
	public APIResult findAll() {
		APIResult apiResult = new APIResult();
		List<Product> productList = itemService.findAll();
		if (productList.size() > 0) {
			apiResult.setResult(itemService.findAll());
		} else {
			apiResult.setErrorMsg("result not found.");
		}
		return apiResult;
	}

	@GetMapping("/product/{id}")
	public APIResult findById(@PathVariable("id") String id) {
		APIResult apiResult = new APIResult();
		Product product = itemService.findById(id);
		if (product != null) {
			apiResult.setResult(product);
		} else {
			apiResult.setErrorMsg("result not found.");
		}
		return apiResult;
	}

	@PostMapping("/product")
	public APIResult createItem(@RequestBody Product product) {
		APIResult apiResult = new APIResult();
		Product productCreated = itemService.createItem(product);
		if (productCreated != null) {
			apiResult.setResult(productCreated);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}

		return apiResult;
	}

	@PutMapping("/product")
	public APIResult updateItem(@RequestBody Product product) {
		APIResult apiResult = new APIResult();
		Product productUpdated = itemService.updateProduct(product);
		if (productUpdated != null) {
			apiResult.setResult(productUpdated);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}

		return apiResult;
	}

	@PutMapping("/product/quantity")
	public APIResult updateQuantityProduct(@RequestBody Product product) {
		APIResult apiResult = new APIResult();
		Product productUpdated = itemService.updateQuantityProduct(product);
		if (productUpdated != null) {
			apiResult.setResult(productUpdated);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return apiResult;
	}

	@DeleteMapping("/product/{id}")
	public APIResult deleteItemById(@PathVariable("id") String id) {
		APIResult apiResult = new APIResult();
		String result = itemService.deleteProduct(id);
		if (result.equalsIgnoreCase("OK")) {
			apiResult.setResult(HttpStatus.OK);
		} else {
			apiResult.setErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR.toString());
		}
		return apiResult;
	}

}
