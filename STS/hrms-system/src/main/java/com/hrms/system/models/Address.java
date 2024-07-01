package com.hrms.system.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="addresses")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int type;
	private String area;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Nation nation;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private State state;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private District district;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private City city;
	
	private String pincode;
	private Boolean isAddressesSame;
	private int propertyType;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Employee emp;
	
	public Address() {
		super();
	}
	
	public Address(int type, String area, Nation nation, State state, District district, City city, String pincode,
			Boolean isAddressesSame, int propertyType, Employee emp) {
		super();
		this.type = type;
		this.area = area;
		this.nation = nation;
		this.state = state;
		this.district = district;
		this.city = city;
		this.pincode = pincode;
		this.isAddressesSame = isAddressesSame;
		this.propertyType = propertyType;
		this.emp = emp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Nation getNation() {
		return nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Boolean getIsAddressesSame() {
		return isAddressesSame;
	}

	public void setIsAddressesSame(Boolean isAddressesSame) {
		this.isAddressesSame = isAddressesSame;
	}

	public int getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
}
