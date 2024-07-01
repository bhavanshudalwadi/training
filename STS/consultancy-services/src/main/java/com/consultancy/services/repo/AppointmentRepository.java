package com.consultancy.services.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consultancy.services.models.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	Optional<Appointment> findById(Long id);
}
