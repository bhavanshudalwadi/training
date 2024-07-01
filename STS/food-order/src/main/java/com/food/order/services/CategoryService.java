package com.food.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.order.models.Category;
import com.food.order.repo.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> getCategories() {
		return repo.findAll();
	}
	
	public void addCategory(Category city) {
		repo.save(city);
	}
	
	public Category getCategory(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Category with id `"+id+"` not found"));
	}

	public void updateCategory(Category city) {
		repo.save(city);
	}
	
	public void deleteCategory(Long id) {
		repo.deleteById(id);
	}
}
