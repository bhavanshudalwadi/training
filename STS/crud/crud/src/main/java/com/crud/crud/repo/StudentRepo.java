package com.crud.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crud.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {
	
}
