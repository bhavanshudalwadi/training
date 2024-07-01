package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Group;
import com.hrms.system.repo.GroupRepository;

@Service
public class GroupService {
	@Autowired
	private GroupRepository repo;
	
	public List<Group> getGroups() {
		return repo.findAll();
	}
}
