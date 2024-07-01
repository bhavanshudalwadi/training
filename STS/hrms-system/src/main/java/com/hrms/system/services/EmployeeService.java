package com.hrms.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Employee;
import com.hrms.system.models.User;
import com.hrms.system.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repo;
	
	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}
	
	public Employee getEmployee(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee with id `"+id+"` not found"));
	}
}
