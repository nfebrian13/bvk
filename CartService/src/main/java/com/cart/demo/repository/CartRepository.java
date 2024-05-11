package com.cart.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cart.demo.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String> {

	@Query("SELECT u FROM Cart u WHERE u.userId = :userId AND u.productId = :productId")
	Optional<Cart> findByProductIdAndUserId(@Param("userId") String userId, @Param("productId") String productId);
	
	List<Cart> findByUserId(String userId);
}
