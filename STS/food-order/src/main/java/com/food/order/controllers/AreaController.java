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

import com.food.order.models.Area;
import com.food.order.services.AreaService;
import com.food.order.services.CityService;
import com.food.order.services.UserService;

@Controller
@RequestMapping("/area")
public class AreaController {
	@Autowired
	private AreaService service;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String areaList(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("areas", service.getAreas());
		return "area-list";
	}
	
	@GetMapping("/add")
	public String addArea(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("cities", cityService.getCities());
		return "area-add";
	}
	
	@PostMapping("/addHandler")
	public String addAreaHandler(@ModelAttribute Area area) {
		service.addArea(area);
		return "redirect:/area/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editArea(@PathVariable Long id, Model model, Principal p) {
		Area oldInfo = service.getArea(id);
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("cities", cityService.getCities());
		model.addAttribute("area", oldInfo);
		return "area-add";
	}
	
	@PostMapping("/updateHandler")
	public String updateAreaHandler(@ModelAttribute Area area) {
		service.updateArea(area);
		return "redirect:/area/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteArea(@PathVariable Long id) {
		service.deleteArea(id);
		return "redirect:/area/list";
	}
}
