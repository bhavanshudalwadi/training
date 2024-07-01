package com.food.order.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.order.models.Area;

public interface AreaRepository extends JpaRepository<Area, Long> {
	Optional<Area> findById(Long id);
}