package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.system.models.Contact;
import com.hrms.system.models.PersonalInfo;

public interface ContactRepository  extends JpaRepository<Contact, Long> {
	Optional<Contact> findById(Long Id);
	
	@Query("SELECT c FROM Contact c WHERE c.emp.id = ?1")
	Optional<Contact> findByEmpId(Long emp_id);
}
