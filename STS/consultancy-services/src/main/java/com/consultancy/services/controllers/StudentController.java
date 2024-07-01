package com.consultancy.services.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.consultancy.services.models.ForgetPassword;
import com.consultancy.services.models.User;
import com.consultancy.services.services.AppointmentService;
import com.consultancy.services.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
    private HttpSession session;
	
	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("username", session.getAttribute("username"));
		Boolean isStudent = service.isStudent((String) session.getAttribute("username"));
		Boolean isConsultant = service.isConsultant((String) session.getAttribute("username"));
		m.addAttribute("isStudent", isStudent);
		m.addAttribute("isConsultant", isConsultant);
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/forget-password")
	public String forgetPassword() {
		return "forget-password";
	}
	
	@GetMapping("/student-registration")
	public String studentRegistration() {
		return "register-student";
	}
	
	@GetMapping("/consultant-registration")
	public String consultantRegistration() {
		return "register-consultant";
	}
	
	@GetMapping("/book-appointment/{id}")
	public String bookAppointment(@PathVariable Long id, Model model) {
		model.addAttribute("consultant", service.getConsultant(id));
		return "book-appointment";
	}
	
	@GetMapping("/change-status/{id}")
	public String changeStatus(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("msg", appointmentService.updateStatus(id));
		return "redirect:/";
	}
	
	@PostMapping("/handleStudentRegistration")
	public String studentRegistrationHandler(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		user.setRole("STUDENT");
		redirectAttributes.addFlashAttribute("msg", service.addStudent(user, "Student"));
		return "redirect:/student-registration";
	}
	
	@PostMapping("/handleConsultantRegistration")
	public String consultantRegistrationHandler(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		user.setRole("CONSULTANT");
		redirectAttributes.addFlashAttribute("msg", service.addStudent(user, "Consultant"));
		return "redirect:/consultant-registration";
	}
	
//	/changePassword
	@PostMapping("/changePassword")
	public String changePassword(RedirectAttributes redirectAttributes, @ModelAttribute ForgetPassword password) {
		String msg = service.updatePassword(password);
		System.out.println(msg);
		redirectAttributes.addFlashAttribute("msg", msg);
		return "redirect:/forget-password";
	}
}
