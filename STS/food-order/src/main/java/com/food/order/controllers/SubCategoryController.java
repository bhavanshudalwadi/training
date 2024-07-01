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

import com.food.order.models.SubCategory;
import com.food.order.services.CategoryService;
import com.food.order.services.SubCategoryService;
import com.food.order.services.UserService;

@Controller
@RequestMapping("/sub-category")
public class SubCategoryController {
	@Autowired
	private SubCategoryService service;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String subCategoryList(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("subCategories", service.getSubCategories());
		return "sub-category-list";
	}
	
	@GetMapping("/add")
	public String addSubCategory(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("categories", categoryService.getCategories());
		return "sub-category-add";
	}
	
	@PostMapping("/addHandler")
	public String addSubCategoryHandler(@ModelAttribute SubCategory subCategory) {
		service.addSubCategory(subCategory);
		return "redirect:/sub-category/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editsubCategory(@PathVariable Long id, Model model, Principal p) {
		SubCategory oldInfo = service.getSubCategory(id);
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("subCategory", oldInfo);
		return "sub-category-add";
	}
	
	@PostMapping("/updateHandler")
	public String updatesubCategoryHandler(@ModelAttribute SubCategory subCategory) {
		service.updateSubCategory(subCategory);
		return "redirect:/sub-category/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deletesubCategory(@PathVariable Long id) {
		service.deleteSubCategory(id);
		return "redirect:/sub-category/list";
	}
}
