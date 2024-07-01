package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Unit;
import com.hrms.system.repo.UnitRepository;

@Service
public class UnitService {
	@Autowired
	private UnitRepository repo;
	
	public List<Unit> getUnits() {
		return repo.findAll();
	}
}
