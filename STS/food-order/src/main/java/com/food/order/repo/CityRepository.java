package com.food.order.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.order.models.City;

public interface CityRepository extends JpaRepository<City, Long> {
	Optional<City> findById(Long id);
}
