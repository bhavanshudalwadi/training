package com.food.order.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String contect_no;
	private String address;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private City city;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Area area;
	
	public Restaurant() {
		
	}

	public Restaurant(String name, String email, String password, String contect_no, String address, City city,
			Area area) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contect_no = contect_no;
		this.address = address;
		this.city = city;
		this.area = area;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContect_no() {
		return contect_no;
	}

	public void setContect_no(String contect_no) {
		this.contect_no = contect_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
