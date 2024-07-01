package com.crud.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.crud.model.Student;
import com.crud.crud.repo.StudentRepo;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentViewController {
	
	@ModelAttribute
	public void common(Model m){
		m.addAttribute("msg", "Data Saved Successful");
	}
	
	@Autowired
	private StudentRepo studentRepo;
	
	//	Send Data To Views
	@GetMapping({"/", "/all-students"})
	public String AllStudents(Model model) {
		List<Student> studentList = new ArrayList<Student>();
		studentRepo.findAll().forEach(studentList::add);
		
		model.addAttribute("students", studentList);
		return "student-list";
	}
	
	@GetMapping("/add-student")
	public String AddStudentForm() {
		return "student-form";
	}
	
	@GetMapping("/edit-student/{id}")
	public String EditStudentForm(@PathVariable Long id, Model model) {
		Optional<Student> oldStudentInfo = studentRepo.findById(id);
		if(oldStudentInfo.isPresent()) {
			Student student = oldStudentInfo.get();
			model.addAttribute("student", student);
		}
		return "student-edit-form";
	}
	
	@PostMapping("/addStudentHendler")
	public String AddStudentHendler(RedirectAttributes redirectAttributes, HttpServletRequest request) {
		
		Student studentObj = new Student();
		studentObj.setName(request.getParameter("name"));
		studentObj.setEnno(request.getParameter("enno"));
		studentObj.setEmail(request.getParameter("email"));
		studentObj.setPhone(request.getParameter("phone"));
		studentRepo.save(studentObj);
		
		redirectAttributes.addFlashAttribute("student", studentObj);
		redirectAttributes.addFlashAttribute("msg", "Student Details Added");
		return "redirect:/add-student";
	}
	
	@PostMapping("/updateStudentHendler")
	public String UpdateStudentHendler(RedirectAttributes redirectAttributes, @ModelAttribute Student student) {
		studentRepo.save(student);
		
		redirectAttributes.addFlashAttribute("student", student);
		redirectAttributes.addFlashAttribute("msg", "Student Details Updated");
		return "redirect:/edit-student/"+student.getId();
	}
}
