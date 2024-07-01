package com.hrms.system.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.system.models.BankBranch;

public interface BankBranchRepository extends JpaRepository<BankBranch, Long> {
	Optional<BankBranch> findById(Long Id);
	
	@Query("SELECT bb FROM BankBranch bb WHERE bb.bank.id = ?1")
	List<BankBranch> findByBank(Long Id);
}
