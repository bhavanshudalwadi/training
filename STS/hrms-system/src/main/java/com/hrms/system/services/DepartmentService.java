package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Department;
import com.hrms.system.repo.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository repo;
	
	public List<Department> getDepartments() {
		return repo.findAll();
	}
}
