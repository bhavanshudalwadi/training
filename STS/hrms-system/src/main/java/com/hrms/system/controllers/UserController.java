package com.hrms.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrms.system.models.User;
import com.hrms.system.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/user/list")
	public String allUsers(Model model) {
		model.addAttribute("users", service.getUsers());
		return "user-list";
	}
	
	@GetMapping("/user/add")
	public String addUser() {
		return "user-add";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/userRegistration")
	public String userRegistration() {
		return "user-registration";
	}
	
	@PostMapping("/userRegistrationHandler")
	public String userRegistrationHandler(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		user.setRoles("ADMIN");
		redirectAttributes.addFlashAttribute("msg", service.userRegistration(user));
		return "redirect:/userRegistration";
	}
	
	@PostMapping("/user/addHandler")
	public String addUser(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		redirectAttributes.addFlashAttribute("msg", service.addUser(user));
		return "redirect:/user/add";
	}
	
	@GetMapping("/user/edit/{id}")
	public String updateUser(@PathVariable Long id, Model model) {
		User oldInfo = service.getUser(id);
		model.addAttribute("user", oldInfo);
		return "user-edit";
	}
	
	@PostMapping("/user/updateHandler")
	public String updateUser(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		redirectAttributes.addFlashAttribute("msg", service.updateUser(user));
		return "redirect:/user/edit/"+user.getId();
	}
	
	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable Long id, Model model) {
		model.addAttribute("msg", service.deleteUser(id));
		return "redirect:/user/list";
	}
}
