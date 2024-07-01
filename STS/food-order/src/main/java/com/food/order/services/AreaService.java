package com.food.order.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.order.models.Area;
import com.food.order.repo.AreaRepository;

@Service
public class AreaService {
	@Autowired
	private AreaRepository repo;
	
	public List<Area> getAreas() {
		return repo.findAll();
	}
	
	public void addArea(Area area) {
		repo.save(area);
	}
	
	public Area getArea(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("City with id `"+id+"` not found"));
	}

	public void updateArea(Area area) {
		repo.save(area);
	}
	
	public void deleteArea(Long id) {
		repo.deleteById(id);
	}
	
	public List<Area> getAreasByCityId(Long city_id) {
		List<Area> list = repo.findAll();
		list = list.stream().filter(a -> a.getCity().getId().equals(city_id)).collect(Collectors.toList());
		return list;
	}
}
