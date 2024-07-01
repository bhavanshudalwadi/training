package com.mvc.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mvc.demo.models.Student;
import com.mvc.demo.services.StudentService;

public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/handleAddStudent")
	public String handleAddStudent(@ModelAttribute Student student, Model model) {
		this.studentService.createStudent(student);
		return "add-student";
	}
}
