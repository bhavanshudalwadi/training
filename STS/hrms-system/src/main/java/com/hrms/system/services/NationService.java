package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Nation;
import com.hrms.system.repo.NationRepository;

@Service
public class NationService {
	@Autowired
	private NationRepository repo;
	
	public List<Nation> getNations() {
		return repo.findAll();
	}
}
