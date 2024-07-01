package com.hrms.system.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hrms.system.models.User;
import com.hrms.system.models.UserEntityUserDetails;
import com.hrms.system.repo.UserRepository;

@Component
public class UserEntityUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = repository.findByEmail(username);
		return user.map(UserEntityUserDetails::new)
			.orElseThrow(() -> new UsernameNotFoundException("User not found: "+username));
	}

}
