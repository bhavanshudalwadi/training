package com.hrms.system.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.system.models.City;

public interface CityRepository extends JpaRepository<City, Long> {
	Optional<City> findById(Long Id);
	
	@Query("SELECT c FROM City c WHERE c.district.id = ?1")
	List<City> findByDistrict(Long nation_id);
}