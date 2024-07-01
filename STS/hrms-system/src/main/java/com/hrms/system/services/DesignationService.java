package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Designation;
import com.hrms.system.repo.DesignationRepository;

@Service
public class DesignationService {
	@Autowired
	private DesignationRepository repo;
	
	public List<Designation> getDesignations() {
		return repo.findAll();
	}
}
