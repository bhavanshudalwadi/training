package com.consultancy.services.controllers;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultancy.services.models.Appointment;
import com.consultancy.services.models.JwtRequest;
import com.consultancy.services.models.JwtResponse;
import com.consultancy.services.models.User;
import com.consultancy.services.security.JwtHelper;
import com.consultancy.services.services.AppointmentService;
import com.consultancy.services.services.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private UserService userService;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private JwtHelper helper;
	
	@Autowired
    private HttpSession session;
	
	private Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@GetMapping("/consultant")
	public ResponseEntity<List<User>> getConsultants() {
		return new ResponseEntity<>(userService.getConsultantList(), HttpStatus.OK);
	}
	
	@GetMapping("/getAppointmentsForStudents")
	public ResponseEntity<List<Appointment>> getStudentAppointments() {
		Long std_id = userService.getUserId((String) (session.getAttribute("username")));
		return new ResponseEntity<>(appointmentService.getAppointmentsForStudent(std_id), HttpStatus.OK);
	}
	
	@GetMapping("/getAppointments")
	public ResponseEntity<List<Appointment>> getAppointments() {
		Long con_id = userService.getUserId((String) (session.getAttribute("username")));
		return new ResponseEntity<>(appointmentService.getAppointments(con_id), HttpStatus.OK);
	}
	
	@PostMapping("/bookConsultant/{duration}")
	public ResponseEntity<String> bookConsultant(@RequestBody Appointment appointment, @PathVariable Long duration) {
		Long std_id = userService.getUserId((String) (session.getAttribute("username")));
		appointment.setStudentId(std_id);
//		Long duration = Long.parseLong(request.getParameter("duration"));
		System.out.println(duration);
		LocalDateTime d = LocalDateTime.ofInstant(appointment.getEndTime().toInstant(), ZoneId.systemDefault());
		LocalDateTime d2 = d.plusHours(duration);
		appointment.setEndTime(Date.from(d2.atZone(ZoneId.systemDefault()).toInstant()));
		
		return new ResponseEntity<>(appointmentService.bookAppointment(appointment), HttpStatus.OK);
	}
}
