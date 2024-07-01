package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.system.models.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {
	Optional<Unit> findById(Long Id);
}
