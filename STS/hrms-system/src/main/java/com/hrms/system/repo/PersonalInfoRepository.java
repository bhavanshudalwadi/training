package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.system.models.PersonalInfo;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Long> {
	Optional<PersonalInfo> findById(Long Id);
	
	@Query("SELECT pi FROM PersonalInfo pi WHERE pi.emp.id = ?1")
	Optional<PersonalInfo> findByEmpId(Long emp_id);
}
