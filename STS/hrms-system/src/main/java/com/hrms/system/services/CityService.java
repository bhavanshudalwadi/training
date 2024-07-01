package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.City;
import com.hrms.system.repo.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository repo;
	
	public List<City> getCities() {
		return repo.findAll();
	}
	
	public List<City> getCities(Long district_id) {
		return repo.findByDistrict(district_id);
	}
}
