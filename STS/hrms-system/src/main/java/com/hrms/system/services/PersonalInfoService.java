package com.hrms.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hrms.system.models.PersonalInfo;
import com.hrms.system.repo.PersonalInfoRepository;

@Service
public class PersonalInfoService {
	@Autowired
	private PersonalInfoRepository repo;
	
	public PersonalInfo addPersonalInfo(PersonalInfo pi) {
		return repo.save(pi);
	}
	
	public PersonalInfo getPersonalInfo(Long emp_id) {
		return repo.findByEmpId(emp_id)
				.orElseThrow(() -> new RuntimeException("PersonalInfo with emp_id `"+emp_id+"` not found"));
	}
}
