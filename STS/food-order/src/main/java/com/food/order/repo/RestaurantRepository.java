package com.food.order.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.order.models.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	Optional<Restaurant> findById(Long id);
}
