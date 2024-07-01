package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.system.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long>  {
	Optional<Group> findById(Long Id);
}
