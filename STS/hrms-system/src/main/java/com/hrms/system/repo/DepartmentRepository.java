package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.system.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	Optional<Department> findById(Long Id);
}
