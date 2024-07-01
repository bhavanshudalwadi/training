package com.food.order.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.order.models.Offer;

public interface OfferRepository  extends JpaRepository<Offer, Long> {
	Optional<Offer> findById(Long id);
	
	@Query("SELECT o FROM Offer o WHERE o.user.id = ?1")
	List<Offer> findByUser(Long id);
}
