package com.hrms.system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.system.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String username);
	
}