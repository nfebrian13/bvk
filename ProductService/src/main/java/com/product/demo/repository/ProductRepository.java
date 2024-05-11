package com.product.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

}
