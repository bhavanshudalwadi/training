package com.spring.security.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.models.Student;
import com.spring.security.services.StudentServices;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private StudentServices studentService;
	
	//	http://localhost:8080/api/student-list-one
	@GetMapping("/student-list-one")
	public List<Student> getStudentListOne() {
		return studentService.getStudents();
	}
	
	//	http://localhost:8080/api/student-list-one
	@GetMapping("/student-list-two")
	public List<Student> getStudentListTwo() {
		return studentService.getStudents();
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal) {
		return principal.getName();
	}
}
