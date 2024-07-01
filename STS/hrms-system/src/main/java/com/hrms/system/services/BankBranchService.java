package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.BankBranch;
import com.hrms.system.models.Employee;
import com.hrms.system.repo.BankBranchRepository;

@Service
public class BankBranchService {
	@Autowired
	private BankBranchRepository repo;
	
	public List<BankBranch> getBankBranchs(Long bank_id) {
		return repo.findByBank(bank_id);
	}
	
	public String getIFSCCode(Long branch_id) {
		return repo.findById(branch_id).get().getIFSCCode();
	}
}
