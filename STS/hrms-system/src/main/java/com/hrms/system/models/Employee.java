package com.hrms.system.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String code;
	private String PAN;
	private String oldCode;
	private String appointmentDate;
	private String bioMatricId;
	private int salutation;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Department dept;
	
	private String fname;
	private String mname;
	private String lname;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Unit unit;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Designation designation;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Group group;
	
	private int eligibleFor;
	private Boolean isGazetted;
	private Boolean isCoverGratuity;
	
	public Employee() {
		super();
	}

	public Employee(String code, String pAN, String oldCode, String appointmentDate,
			String bioMatricId, int salutation, Department dept, String fname, String mname, String lname, Unit unit,
			Designation designation, Group group, int eligibleFor, Boolean isGazetted, Boolean isCoverGratuity) {
		super();
		this.code = code;
		PAN = pAN;
		this.oldCode = oldCode;
		this.appointmentDate = appointmentDate;
		this.bioMatricId = bioMatricId;
		this.salutation = salutation;
		this.dept = dept;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.unit = unit;
		this.designation = designation;
		this.group = group;
		this.eligibleFor = eligibleFor;
		this.isGazetted = isGazetted;
		this.isCoverGratuity = isCoverGratuity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public String getOldCode() {
		return oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getBioMatricId() {
		return bioMatricId;
	}

	public void setBioMatricId(String bioMatricId) {
		this.bioMatricId = bioMatricId;
	}

	public int getSalutation() {
		return salutation;
	}

	public void setSalutation(int salutation) {
		this.salutation = salutation;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getEligibleFor() {
		return eligibleFor;
	}

	public void setEligibleFor(int eligibleFor) {
		this.eligibleFor = eligibleFor;
	}

	public Boolean getIsGazetted() {
		return isGazetted;
	}

	public void setIsGazetted(Boolean isGazetted) {
		this.isGazetted = isGazetted;
	}

	public Boolean getIsCoverGratuity() {
		return isCoverGratuity;
	}

	public void setIsCoverGratuity(Boolean isCoverGratuity) {
		this.isCoverGratuity = isCoverGratuity;
	}
}
