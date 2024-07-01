package com.food.order.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.order.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Optional<Category> findById(Long id);
}
