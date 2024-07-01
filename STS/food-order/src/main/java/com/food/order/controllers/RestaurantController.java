package com.food.order.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.food.order.models.Restaurant;
import com.food.order.models.User;
import com.food.order.services.AreaService;
import com.food.order.services.CityService;
import com.food.order.services.RestaurantService;
import com.food.order.services.UserService;

@Controller
public class RestaurantController {
	@Autowired
	private RestaurantService service;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/restaurant-list")
	public String areaList(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("restaurants", service.getRestaurants());
		return "restaurant-list";
	}
	
	@GetMapping("/restaurantRegistration")
	public String restaurantRegistration(Model model) {
		model.addAttribute("cities", cityService.getCities());
//		model.addAttribute("areas", areaService.getAreas());
		return "restaurant-registration";
	}
	
	@PostMapping("/restaurantRegistrationHandler")
	public String restaurantRegistrationHandler(@ModelAttribute Restaurant restaurant) {
		
		User user = new User();
		user.setName(restaurant.getName());
		user.setEmail(restaurant.getEmail());
		user.setPassword(restaurant.getPassword());
		user.setRoles("RESTAURANT");
		userService.addUser(user);
		
		service.addRestaurant(restaurant);
		return "redirect:/login";
	}
}
