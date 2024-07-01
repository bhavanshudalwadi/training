package com.hrms.system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.system.models.Contact;
import com.hrms.system.repo.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repo;
	
	public Contact addContactDetails(Contact contact) {
		return repo.save(contact);
	}
	
	public Contact getContactDetails(Long emp_id) {
		return repo.findByEmpId(emp_id)
				.orElseThrow(() -> new RuntimeException("ContactDetails with emp_id `"+emp_id+"` not found"));
	}
}
