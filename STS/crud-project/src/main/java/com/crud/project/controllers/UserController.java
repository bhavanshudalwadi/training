package com.crud.project.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.project.models.User;
import com.crud.project.services.UserService;

@Controller
//@EnableMethodSecurity
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
//	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String welcome(Principal principal, Model model) {
		model.addAttribute("username", principal.getName());
		model.addAttribute("isAdmin", service.isAdmin(principal.getName()));
		return "index";
	}
	
	@GetMapping("/profile")
//	@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
	public String profile(Principal principal, Model model) {
		model.addAttribute("user", service.getUserByEmail(principal.getName()));
		return "profile";
	}
	
	@GetMapping("/user/list")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String allUsers(Model model) {
		model.addAttribute("users", service.getUsers());
		return "user-list";
	}
	
	@GetMapping("/user/add")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String addUser() {
		return "user-add";
	}
	
	@GetMapping("/login")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String login() {
		return "custom-login";
	}
	
	@GetMapping("/userRegistration")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String userRegistration() {
		return "user-registration";
	}
	
	@PostMapping("/userRegistrationHandler")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String userRegistrationHandler(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		user.setRoles("USER");
		redirectAttributes.addFlashAttribute("msg", service.userRegistration(user));
		return "redirect:/userRegistration";
	}
	
	@PostMapping("/user/addHandler")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String addUser(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		redirectAttributes.addFlashAttribute("msg", service.addUser(user));
		return "redirect:/user/add";
	}
	
	@GetMapping("/user/edit/{id}")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String updateUser(@PathVariable Long id, Model model) {
		User oldInfo = service.getUser(id);
		model.addAttribute("user", oldInfo);
		return "user-edit";
	}
	
	@PostMapping("/user/updateHandler")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String updateUser(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
		redirectAttributes.addFlashAttribute("msg", service.updateUser(user));
		return "redirect:/user/edit/"+user.getId();
	}
	
	@GetMapping("/user/delete/{id}")
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteUser(@PathVariable Long id, Model model) {
		model.addAttribute("msg", service.deleteUser(id));
		return "redirect:/user/list";
	}
}
