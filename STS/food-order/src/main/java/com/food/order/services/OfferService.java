package com.food.order.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.order.models.Offer;
import com.food.order.repo.OfferRepository;

@Service
public class OfferService {
	@Autowired
	private OfferRepository repo;
	
	@Autowired
	private UserService userService;
	
	public void addOffer(Offer offer) {
		repo.save(offer);
	}
	
	public List<Offer> getOffers(String email) {
		return repo.findByUser(userService.getUserByEmail(email).getId());
	}
	
	public Offer getOffer(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Offer with id `"+id+"` not found"));
	}

	public void updateOffer(Offer offer) {
		repo.save(offer);
	}
	
	public void deleteOffer(Long id) {
		repo.deleteById(id);
	}
}
