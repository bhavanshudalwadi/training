package com.crud.project.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String roles;	// ADMIN, USER
	private String education;
	private String company;
	private String bio;
	private Long country;
	private Long state;
	private Long city;
	
	public User() {
		
	}

	public User(String name, String email, String phone, String password, String roles, String education,
			String company, String bio, Long country, Long state, Long city) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.roles = roles;
		this.education = education;
		this.company = company;
		this.bio = bio;
		this.country = country;
		this.state = state;
		this.city = city;
	}

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Long getCountry() {
		return country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public Long getCity() {
		return city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "{\"id\": " + id + ", \"name\": '" + name + "',\"email\": '" + email + "' , \"phone\": '" + phone + "', \"password\": '" + password
				+ "', \"roles\": '" + roles + "', \"education\": '" + education + "', \"company\": '" + company + "', \"bio\": '" + bio
				+ "', \"country\": " + country + ", \"state\": " + state + ", \"city\": " + city + "}";
	}

	
	
}
