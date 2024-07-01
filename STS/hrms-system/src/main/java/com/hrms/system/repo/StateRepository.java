package com.hrms.system.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.system.models.State;

public interface StateRepository  extends JpaRepository<State, Long> {
	Optional<State> findById(Long Id);
	
	@Query("SELECT s FROM State s WHERE s.nation.id = ?1")
	List<State> findByNation(Long nation_id);
}