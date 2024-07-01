package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.system.models.Nation;

public interface NationRepository extends JpaRepository<Nation, Long> {
	Optional<Nation> findById(Long Id);
}
