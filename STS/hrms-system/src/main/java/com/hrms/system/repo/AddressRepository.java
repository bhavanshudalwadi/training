package com.hrms.system.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.system.models.Address;

public interface AddressRepository  extends JpaRepository<Address, Long> {
	Optional<Address> findById(Long Id);
	
	@Query("SELECT a FROM Address a WHERE a.emp.id = ?1")
	List<Address> findByEmpId(Long emp_id);
}
