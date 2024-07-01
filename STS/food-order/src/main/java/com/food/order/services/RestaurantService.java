package com.food.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.food.order.models.Restaurant;
import com.food.order.repo.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	public List<Restaurant> getRestaurants() {
		return repo.findAll();
	}
	
	public void addRestaurant(Restaurant restaurant) {
		restaurant.setPassword(passwordEncoder.encode(restaurant.getPassword()));
		repo.save(restaurant);
	}
}
