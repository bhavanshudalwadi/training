package com.food.order.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.order.models.SubCategory;
import com.food.order.repo.SubCategoryRepository;

@Service
public class SubCategoryService {
	@Autowired
	private SubCategoryRepository repo;
	
	public List<SubCategory> getSubCategories() {
		return repo.findAll();
	}
	
	public void addSubCategory(SubCategory subCategory) {
		repo.save(subCategory);
	}
	
	public SubCategory getSubCategory(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("SubCategory with id `"+id+"` not found"));
	}

	public void updateSubCategory(SubCategory subCategory) {
		repo.save(subCategory);
	}
	
	public void deleteSubCategory(Long id) {
		repo.deleteById(id);
	}
	
	public List<SubCategory> getSubCatByCatId(Long cat_id) {
		List<SubCategory> list = repo.findAll();
		list = list.stream().filter(s -> s.getCategory().getId().equals(cat_id)).collect(Collectors.toList());
		list.forEach(l -> System.out.print(l + " "));
		return list;
	}
}
