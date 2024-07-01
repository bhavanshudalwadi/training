package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.State;
import com.hrms.system.repo.StateRepository;

@Service
public class StateService {
	@Autowired
	private StateRepository repo;
	
	public List<State> getStates() {
		return repo.findAll();
	}
	
	public List<State> getStates(Long nation_id) {
		return repo.findByNation(nation_id);
	}
}
