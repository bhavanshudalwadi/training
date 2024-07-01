package com.food.order.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.food.order.models.City;
import com.food.order.models.User;
import com.food.order.services.CityService;
import com.food.order.services.UserService;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private CityService service;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String cityList(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("cities", service.getCities());
		return "city-list";
	}
	
	@GetMapping("/add")
	public String addCity(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		return "city-add";
	}
	
	@PostMapping("/addHandler")
	public String addCityHandler(@ModelAttribute City city) {
		service.addCity(city);
		return "redirect:/city/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editCity(@PathVariable Long id, Model model, Principal p) {
		City oldInfo = service.getCity(id);
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("city", oldInfo);
		return "city-add";
	}
	
	@PostMapping("/updateHandler")
	public String updateCityHandler(@ModelAttribute City city) {
		service.updateCity(city);
		return "redirect:/city/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCity(@PathVariable Long id) {
		service.deleteCity(id);
		return "redirect:/city/list";
	}
}
