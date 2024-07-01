package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Bank;
import com.hrms.system.repo.BankRepository;

@Service
public class BankService {
	@Autowired
	private BankRepository repo;
	
	public List<Bank> getBanks() {
		return repo.findAll();
	}
}
