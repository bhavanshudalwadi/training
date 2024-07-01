package com.consultancy.services.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@DateTimeFormat(pattern = "hh:mm:ss")
    private Date createdOn;
	private String description;
	@DateTimeFormat(pattern = "hh:mm:ss")
	private Date modifiedOn;
	private Long status;
	@DateTimeFormat(pattern = "hh:mm:ss")
	private Date startTime;
	@DateTimeFormat(pattern = "hh:mm:ss")
	private Date endTime;
	private Long consultantId;
	private Long studentId;
	
	public Appointment() {
		
	}
	
	public Appointment(Date createdOn, String description, Date modifiedOn, Long status, Date startTime, Date endTime,
			Long consultantId, Long studentId) {
		super();
		this.createdOn = createdOn;
		this.description = description;
		this.modifiedOn = modifiedOn;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.consultantId = consultantId;
		this.studentId = studentId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Long getConsultantId() {
		return consultantId;
	}
	public void setConsultantId(Long consultantId) {
		this.consultantId = consultantId;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	
}
