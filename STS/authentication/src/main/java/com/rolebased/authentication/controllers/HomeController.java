package com.rolebased.authentication.controllers;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	@GetMapping("/")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public String index(Model model, Principal principal) {
		model.addAttribute("username", principal.getName());
		return "index";
	}
	
	@GetMapping("/user-details")
	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	public String getUserDetails() {
		return "user-details";
	}
	
	@GetMapping("/admin-details")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public String getAdminDetails() {
		return "admin-details";
	}
	
	@GetMapping("/profile/{id}")
	public String getProfileInfo(Model model, @PathVariable Long id, Principal principal) {
		if(principal.getName().equals("user") && id == 1) {
			model.addAttribute("username", principal.getName());
			return "profile";
		}else if(principal.getName().equals("admin") && id == 2) {
			model.addAttribute("username", principal.getName());
			return "profile";
		}
		model.addAttribute("sjfhgdh", "ACCESS-DENIED");
		return "redirect:/";
	}
}
