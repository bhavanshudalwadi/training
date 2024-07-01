package com.consultancy.services.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultancy.services.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String username);
	
	Optional<User> findByEmailAndPassword(String username, String password);
}
