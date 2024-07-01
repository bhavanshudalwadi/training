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

import com.food.order.models.Category;
import com.food.order.services.CategoryService;
import com.food.order.services.UserService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String categoryList(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("categories", service.getCategories());
		return "category-list";
	}
	
	@GetMapping("/add")
	public String addCategory(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		return "category-add";
	}
	
	@PostMapping("/addHandler")
	public String addCategoryHandler(@ModelAttribute Category category) {
		service.addCategory(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable Long id, Model model, Principal p) {
		Category oldInfo = service.getCategory(id);
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("category", oldInfo);
		return "category-add";
	}
	
	@PostMapping("/updateHandler")
	public String updateCategoryHandler(@ModelAttribute Category category) {
		service.updateCategory(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable Long id) {
		service.deleteCategory(id);
		return "redirect:/category/list";
	}
}
