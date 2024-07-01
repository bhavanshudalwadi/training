package com.hrms.system.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.system.models.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
	Optional<District> findById(Long Id);
	
	@Query("SELECT d FROM District d WHERE d.state.id = ?1")
	List<District> findByState(Long state_id);
}