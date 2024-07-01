package com.food.order.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.order.models.Area;
import com.food.order.models.SubCategory;
import com.food.order.models.User;
import com.food.order.services.AreaService;
import com.food.order.services.SubCategoryService;
import com.food.order.services.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAreaList/{city_id}")
	public ResponseEntity<List<Area>> getAreaList(@PathVariable Long city_id) {
		return new ResponseEntity<>(areaService.getAreasByCityId(city_id), HttpStatus.OK);
	}
	
	@GetMapping("/getSubCategoryList/{cat_id}")
	public ResponseEntity<List<SubCategory>> getSubCategoryList(@PathVariable Long cat_id) {
		return new ResponseEntity<>(subCategoryService.getSubCatByCatId(cat_id), HttpStatus.OK);
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<String> addAdmin(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity<>("User Created Successfully", HttpStatus.OK);
	}
}
