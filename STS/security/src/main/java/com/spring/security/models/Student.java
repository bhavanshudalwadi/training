package com.spring.security.models;

public class Student {
	private Long id;
	private String name;
	private String enno;
	private String email;
	private String phone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEnno() {
		return enno;
	}
	public void setEnno(String enno) {
		this.enno = enno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Student(String name, String enno, String email, String phone) {
		this.name = name;
		this.enno = enno;
		this.email = email;
		this.phone = phone;
	}
	
	public Student() {
		
	}
}
