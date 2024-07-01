package com.food.order.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.food.order.services.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String index(Principal p, Model model) {
		model.addAttribute("userRole", service.getUserRole(p.getName()));
		return "index";
	}
}
