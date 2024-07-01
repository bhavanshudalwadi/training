package com.food.order.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.order.models.Complaint;
import com.food.order.models.Product;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
	Optional<Complaint> findById(Long id);
	
	@Query("SELECT c FROM Complaint c WHERE c.user.id = ?1")
	List<Complaint> findByUser(Long id);
}
