package com.food.order.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.food.order.models.Complaint;
import com.food.order.models.Offer;
import com.food.order.repo.ComplaintRepository;

@Service
public class ComplaintService {
	@Autowired
	private ComplaintRepository repo;
	
	@Autowired
	private UserService userService;
	
	private final String PATH = "src/main/resources/static/upload/pdf/";
	
	public String uploadPdf(String path, MultipartFile file) throws IOException {
		String name = "";
		if(path != null && file != null) {
			Random random = new Random();
			name = (random.nextInt(900)+100) + file.getOriginalFilename();
			String filePath = path + File.separator + name;
			File f = new File(path);
			if(!f.exists() ) {
				f.mkdir();
			}
			Files.copy(file.getInputStream(), Paths.get(filePath));
			return name;
		}
		return name;
	}
	
	public void addComplaint(MultipartFile pdf, Complaint complaint) {
		String fileName = "";
		try {
			fileName = this.uploadPdf(PATH, pdf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		complaint.setComplaintDate(df.format(d));
		complaint.setAttachment(fileName);
		complaint.setStatus(false);
		repo.save(complaint);
	}
	
	public List<Complaint> getComplaints(String email) {
		return repo.findByUser(userService.getUserByEmail(email).getId());
	}
	
	public List<Complaint> getAllComplaints() {
		return repo.findAll();
	}
	
	public Complaint getComplaint(Long id) {
		return repo.findById(id)
				.orElseThrow(() -> new RuntimeException("Complaint with id `"+id+"` not found"));
	}
	
	public void resolveComplaint(Long id, String reply) {
		Optional<Complaint> complaints = repo.findById(id);
		Complaint complaint = complaints.get();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		complaint.setReplyDate(df.format(d));
		complaint.setStatus(true);
		complaint.setReply(reply);
		repo.save(complaint);
	}
}
