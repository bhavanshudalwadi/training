package com.food.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.food.order.models.City;
import com.food.order.models.User;
import com.food.order.repo.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository repo;
	
	public List<City> getCities() {
		return repo.findAll();
	}
	
	public void addCity(City city) {
		repo.save(city);
	}
	
	public City getCity(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("City with id `"+id+"` not found"));
	}

	public void updateCity(City city) {
		repo.save(city);
	}
	
	public void deleteCity(Long id) {
		repo.deleteById(id);
	}
}
