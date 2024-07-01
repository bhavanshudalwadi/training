package com.food.order.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.order.models.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
	Optional<SubCategory> findById(Long id);
}
