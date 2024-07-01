package com.hrms.system.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hrms.system.models.User;
import com.hrms.system.repo.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
	
	List<User> list = new ArrayList<User>();
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	public List<User> getUsers() {
		return repo.findAll();
	}
	
	public User getUser(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("User with id `"+id+"` not found"));
	}
	
	public String deleteUser(Long id) {
		repo.deleteById(id);
		return "User Deleted";
	}
	
	public String addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
		return "New User Added";
	}
	
	public String userRegistration(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
		return "User Registration Successfull";
	}
	
	public String updateUser(User user) {
		repo.save(user);
		return "User Updated";
	}
	
	public Boolean isAdmin(String email) {
		Optional<User> userDetails = repo.findByEmail(email);
		if(userDetails.isPresent() && userDetails.get().getRoles().toUpperCase().contains("ADMIN")) {
			return true;
		}
		return false;
	}
	
	public User getUserByEmail(String email) {
		Optional<User> userDetails = repo.findByEmail(email);
		if(userDetails.isPresent()) {
			return userDetails.get();
		}
		throw new RuntimeException("User with email `"+email+"` not found");
	}
	
	public String getUserRole(String email) {
		Optional<User> userDetails = repo.findByEmail(email);
		if(userDetails.isPresent()) {
			return userDetails.get().getRoles();
		}
		return "";
	}
}
