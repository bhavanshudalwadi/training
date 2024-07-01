package com.hrms.system.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Address;
import com.hrms.system.repo.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository repo;
	
	public Address addAddress(Address address) {
		return repo.save(address);
	}
	
	public List<Address> getAddresses() {
		return repo.findAll();
	}
	
	public List<Address> getAddresses(Long emp_id) {
		return repo.findByEmpId(emp_id);
	}
	
	public String deleteAddress(Long id) {
		repo.deleteById(id);
		return "Address Deleted";
	}
}
