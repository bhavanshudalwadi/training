package com.food.order.controllers;

import java.io.IOException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.food.order.models.Product;
import com.food.order.services.CategoryService;
import com.food.order.services.ProductService;
import com.food.order.services.SubCategoryService;
import com.food.order.services.UserService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	private final String PATH = "src/main/resources/static/upload/";
	
	@GetMapping("/list")
	public String productList(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("products", service.getProducts(p.getName()));
		return "product-list";
	}
	
	@GetMapping("/add")
	public String addProduct(Model model, Principal p) {
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("user_id", userService.getUserByEmail(p.getName()).getId());
//		model.addAttribute("subcategories", subCategoryService.getSubCategories());
		return "product-add";
	}
	
	@PostMapping("/addHandler")
	public String addProductHandler(
		@RequestParam("img") MultipartFile image,
		@ModelAttribute Product product
	) {
		String fileName = null;
		try {
			fileName = service.uploadImage(PATH, image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		product.setImage(fileName);
		service.addProduct(product);
		return "redirect:/product/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable Long id, Model model, Principal p) {
		Product oldInfo = service.getProduct(id);
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("user_id", userService.getUserByEmail(p.getName()).getId());
//		model.addAttribute("subcategories", subCategoryService.getSubCategories());
		model.addAttribute("product", oldInfo);
		return "product-add";
	}
	
	@PostMapping("/updateHandler")
	public String updateProductHandler(
		@RequestParam("img") MultipartFile image,
		@ModelAttribute Product product
	) {
		if(!image.isEmpty() ) {			
			String fileName = "";
			try {
				fileName = service.uploadImage(PATH, image);
			} catch (IOException e) {
				e.printStackTrace();
			}
			product.setImage(fileName);
		}
		service.updateProduct(product);
		return "redirect:/product/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
		return "redirect:/product/list";
	}
}
