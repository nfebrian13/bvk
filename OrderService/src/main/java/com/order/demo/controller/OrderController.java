package com.order.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.dto.OrderDto;
import com.order.demo.entity.OrderCart;
import com.order.demo.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public OrderCart addToCart(@RequestBody OrderDto orderDto) {
		return orderService.order(orderDto.getUserId());
	}
}
