package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.system.models.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
	Optional<Bank> findById(Long Id);
}
