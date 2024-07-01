package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.District;
import com.hrms.system.repo.DistrictRepository;

@Service
public class DistrictService {
	@Autowired
	private DistrictRepository repo;
	
	public List<District> getDistricts() {
		return repo.findAll();
	}
	
	public List<District> getDistricts(Long state_id) {
		return repo.findByState(state_id);
	}
}
