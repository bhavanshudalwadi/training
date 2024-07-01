package com.consultancy.services.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.consultancy.services.models.Appointment;
import com.consultancy.services.models.ForgetPassword;
import com.consultancy.services.models.User;
import com.consultancy.services.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();																																																																																																																	 
	}
	
	public String addStudent(User user, String type) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		repo.save(user);
		return type+" Registration Successful";
	}
	
	public List<User> getConsultantList() {
		List<User> list = repo.findAll();
		list = list.stream().filter(u -> u.getRole().equals("CONSULTANT")).collect(Collectors.toList()); 
		System.out.println(list);
		return list;
	}
	
	public User getConsultant(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Consultant with id `"+id+"` not found"));
	}
	
	public Boolean isStudent(String email) {
		Optional<User> userDetails = repo.findByEmail(email);
		if(userDetails.isPresent() && userDetails.get().getRole().toUpperCase().contains("STUDENT")) {
			return true;
		}
		return false;
	}
	
	public Long getUserId(String email) {
		Optional<User> userDetails = repo.findByEmail(email);
		if(userDetails.isPresent()) {
			return userDetails.get().getId();
		}
		return (long) -1;
	}
	
	public Boolean isConsultant(String email) {
		Optional<User> userDetails = repo.findByEmail(email);
		if(userDetails.isPresent() && userDetails.get().getRole().toUpperCase().contains("CONSULTANT")) {
			return true;
		}
		return false;
	}
	
	public String updatePassword(ForgetPassword password) {
		Optional<User> userDetails = repo.findByEmailAndPassword(password.getUsername(), passwordEncoder().encode(password.getOldPassword()));
		if(userDetails.isPresent()) {
			User user = userDetails.get();
			
			System.out.println(user);
			
			user.setPassword(passwordEncoder().encode(password.getNewPassword()));
			repo.save(user);
			return "Password Updated";
		}
		return "User not found";
	}
}
