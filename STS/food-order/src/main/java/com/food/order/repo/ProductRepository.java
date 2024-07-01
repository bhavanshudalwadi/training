package com.food.order.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.order.models.Product;
import com.food.order.models.User;

public interface ProductRepository extends JpaRepository<Product, Long>  {
	Optional<Product> findById(Long id);
	
	@Query("SELECT p FROM Product p WHERE p.user.id = ?1")
	List<Product> findByUser(Long id);
}
