package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.system.models.Designation;

public interface DesignationRepository extends JpaRepository<Designation, Long> {
	Optional<Designation> findById(Long Id);
}
