package com.order.demo.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.demo.entity.OrderCart;

public interface OrderRepository extends JpaRepository<OrderCart, String> {

}
