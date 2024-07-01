package com.hrms.system.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String workPhone;
	private String ext;
	private String workMobile;
	private String homePhone;
	private String homeMobile;
	private String coporateEmail;
	private String personalEmail;
	private String secondaryEmail;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Employee emp;

	public Contact() {
		super();
	}

	public Contact(String workPhone, String ext, String workMobile, String homePhone, String homeMobile,
			String coporateEmail, String personalEmail, String secondaryEmail, Employee emp) {
		super();
		this.workPhone = workPhone;
		this.ext = ext;
		this.workMobile = workMobile;
		this.homePhone = homePhone;
		this.homeMobile = homeMobile;
		this.coporateEmail = coporateEmail;
		this.personalEmail = personalEmail;
		this.secondaryEmail = secondaryEmail;
		this.emp = emp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getWorkMobile() {
		return workMobile;
	}

	public void setWorkMobile(String workMobile) {
		this.workMobile = workMobile;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getHomeMobile() {
		return homeMobile;
	}

	public void setHomeMobile(String homeMobile) {
		this.homeMobile = homeMobile;
	}

	public String getCoporateEmail() {
		return coporateEmail;
	}

	public void setCoporateEmail(String coporateEmail) {
		this.coporateEmail = coporateEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
}
