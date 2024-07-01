package com.food.order.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.food.order.models.Complaint;
import com.food.order.services.ComplaintService;
import com.food.order.services.UserService;

@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	
	@Autowired
	private ComplaintService service;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin-list")
	public String complaintAdminList(Model model, Principal p) {
		List<Complaint> list = service.getAllComplaints();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dp = new SimpleDateFormat("yyyy-MM-dd");  
		list.forEach(l -> {
			try {
				if(l.getComplaintDate() != null) {					
					l.setComplaintDate(df.format(dp.parse(l.getComplaintDate())));
				}
				if(l.getReplyDate() != null) {					
					l.setReplyDate(df.format(dp.parse(l.getReplyDate())));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("complaints", list);
		return "complaint-admin-list";
	}
	
	@GetMapping("/list")
	public String complaintList(Model model, Principal p) {
		List<Complaint> list = service.getComplaints(p.getName());
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dp = new SimpleDateFormat("yyyy-MM-dd");  
		list.forEach(l -> {
			try {
				if(l.getComplaintDate() != null) {					
					l.setComplaintDate(df.format(dp.parse(l.getComplaintDate())));
				}
				if(l.getReplyDate() != null) {					
					l.setReplyDate(df.format(dp.parse(l.getReplyDate())));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("complaints", list);
		return "complaint-list";
	}
	
	@GetMapping("/add")
	public String addComplaint(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		return "complaint-add";
	}
	
	@GetMapping("/resolve/{id}")
	public String resolveComplaint(Model model, Principal p, @PathVariable Long id) {
		model.addAttribute("complaint", service.getComplaint(id));
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		return "complaint-resolve";
	}
	
	@PostMapping("/addHandler")
	public String addComplaintHandler(
		@RequestParam("pdf") MultipartFile pdf,
		@ModelAttribute Complaint complaint,
		Principal p
	) {
		complaint.setUser(userService.getUserByEmail(p.getName()));
		service.addComplaint(pdf, complaint);
		return "redirect:/complaint/list";
	}
	
	@PostMapping("/resolveHandler")
	public String resolveComplaintHandler(
		@RequestParam("reply") String reply,
		@RequestParam("id") Long id
	) {
		System.out.println(id + " " + reply);
		service.resolveComplaint(id, reply);
		return "redirect:/complaint/admin-list";
	}
}
