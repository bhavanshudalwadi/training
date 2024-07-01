package com.consultancy.services.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consultancy.services.models.Appointment;
import com.consultancy.services.models.User;
import com.consultancy.services.repo.AppointmentRepository;

@Service
public class AppointmentService {
	@Autowired
	private AppointmentRepository repo;
	
	public String bookAppointment(Appointment appointment) {
		repo.save(appointment);
		return "Appointment Booked";
	}
	
	public List<Appointment> getAppointmentsForStudent(Long student_id) {
		List<Appointment> list = repo.findAll();
		list = list.stream().filter(a -> a.getStudentId().equals(student_id)).collect(Collectors.toList()); 
		return list;
	}
	
	public List<Appointment> getAppointments(Long con_id) {
		List<Appointment> list = repo.findAll();
		list = list.stream().filter(a -> a.getConsultantId().equals(con_id)).collect(Collectors.toList()); 
		return list;
	}
	
	public String updateStatus(Long id) {
		Optional<Appointment> userDetails = repo.findById(id);
		Appointment appintment = userDetails.get();
		if(appintment.getStatus().equals((long) 0)) {
			appintment.setStatus((long) 1);
		}else {
			appintment.setStatus((long) 0);
		}
		repo.save(appintment);
		return "Appointment Status Updated";
	}
}
