package com.hrms.system.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="personalInfo")
public class PersonalInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private int gender;
	private int marriageStatus;
	private String DOB;
	private String DOM;
	private String birthPlace;
	private int community;
	private String UID;
	private String GPFAccNo;
	private int religion;
	private int caste;
	private String communityCatRef;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Nation nationality;
	
	private String PLInsPolicyNo;
	private String hobbies;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Bank bank;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private BankBranch bankBranch;
	
	private String bankAccNO;
	private String IFSCCode;
	private String BSRCode;
	private String passportNo;
	private String passportExpDt;
	private String visaDetails;
	private String drivingLicNo;
	private int drivingLicVehicleType;
	private String drivingLicValidUptoDt;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private State drivingLicIssuerState;
	
	private Boolean isOwnGovVehicle;
	private Boolean isGovVehicleUsedForOnDuty;
	private String govVehicleDetails;
	private Boolean isResidentOfOtherCountry;
	private String migDtOfIndia;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Nation residentOf;
	
	private String otherCountryAddress;
	private Boolean isAnyDiciplinaryProceeding;
	private String additionalInfo;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Employee emp;

	public PersonalInfo() {
		super();
	}

	public PersonalInfo(int gender, int marriageStatus, String dOB, String dOM, String birthPlace, int community,
			String uID, String gPFAccNo, int religion, int caste, String communityCatRef, Nation nationality,
			String pLInsPolicyNo, String hobbies, Bank bank, BankBranch bankBranch, String bankAccNO, String iFSCCode,
			String bSRCode, String passportNo, String passportExpDt, String visaDetails, String drivingLicNo,
			int drivingLicVehicleType, String drivingLicValidUptoDt, State drivingLicIssuerState, Boolean isOwnGovVehicle,
			Boolean isGovVehicleUsedForOnDuty, String govVehicleDetails, Boolean isResidentOfOtherCountry,
			String migDtOfIndia, Nation residentOf, String otherCountryAddress, Boolean isAnyDiciplinaryProceeding,
			String additionalInfo, Employee emp) {
		super();
		this.gender = gender;
		this.marriageStatus = marriageStatus;
		DOB = dOB;
		DOM = dOM;
		this.birthPlace = birthPlace;
		this.community = community;
		UID = uID;
		GPFAccNo = gPFAccNo;
		this.religion = religion;
		this.caste = caste;
		this.communityCatRef = communityCatRef;
		this.nationality = nationality;
		PLInsPolicyNo = pLInsPolicyNo;
		this.hobbies = hobbies;
		this.bank = bank;
		this.bankBranch = bankBranch;
		this.bankAccNO = bankAccNO;
		IFSCCode = iFSCCode;
		BSRCode = bSRCode;
		this.passportNo = passportNo;
		this.passportExpDt = passportExpDt;
		this.visaDetails = visaDetails;
		this.drivingLicNo = drivingLicNo;
		this.drivingLicVehicleType = drivingLicVehicleType;
		this.drivingLicValidUptoDt = drivingLicValidUptoDt;
		this.drivingLicIssuerState = drivingLicIssuerState;
		this.isOwnGovVehicle = isOwnGovVehicle;
		this.isGovVehicleUsedForOnDuty = isGovVehicleUsedForOnDuty;
		this.govVehicleDetails = govVehicleDetails;
		this.isResidentOfOtherCountry = isResidentOfOtherCountry;
		this.migDtOfIndia = migDtOfIndia;
		this.residentOf = residentOf;
		this.otherCountryAddress = otherCountryAddress;
		this.isAnyDiciplinaryProceeding = isAnyDiciplinaryProceeding;
		this.additionalInfo = additionalInfo;
		this.emp = emp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(int marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getDOM() {
		return DOM;
	}

	public void setDOM(String dOM) {
		DOM = dOM;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public int getCommunity() {
		return community;
	}

	public void setCommunity(int community) {
		this.community = community;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getGPFAccNo() {
		return GPFAccNo;
	}

	public void setGPFAccNo(String gPFAccNo) {
		GPFAccNo = gPFAccNo;
	}

	public int getReligion() {
		return religion;
	}

	public void setReligion(int religion) {
		this.religion = religion;
	}

	public int getCaste() {
		return caste;
	}

	public void setCaste(int caste) {
		this.caste = caste;
	}

	public String getComuunityCatRef() {
		return communityCatRef;
	}

	public void setComuunityCatRef(String communityCatRef) {
		this.communityCatRef = communityCatRef;
	}

	public Nation getNationality() {
		return nationality;
	}

	public void setNationality(Nation nationality) {
		this.nationality = nationality;
	}

	public String getPLInsPolicyNo() {
		return PLInsPolicyNo;
	}

	public void setPLInsPolicyNo(String pLInsPolicyNo) {
		PLInsPolicyNo = pLInsPolicyNo;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public BankBranch getBankBranch() {
		return bankBranch;
	}

	public void setBankBranch(BankBranch bankBranch) {
		this.bankBranch = bankBranch;
	}

	public String getBankAccNO() {
		return bankAccNO;
	}

	public void setBankAccNO(String bankAccNO) {
		this.bankAccNO = bankAccNO;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public String getBSRCode() {
		return BSRCode;
	}

	public void setBSRCode(String bSRCode) {
		BSRCode = bSRCode;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPassportExpDt() {
		return passportExpDt;
	}

	public void setPassportExpDt(String passportExpDt) {
		this.passportExpDt = passportExpDt;
	}

	public String getVisaDetails() {
		return visaDetails;
	}

	public void setVisaDetails(String visaDetails) {
		this.visaDetails = visaDetails;
	}

	public String getDrivingLicNo() {
		return drivingLicNo;
	}

	public void setDrivingLicNo(String drivingLicNo) {
		this.drivingLicNo = drivingLicNo;
	}

	public int getDrivingLicVehicleType() {
		return drivingLicVehicleType;
	}

	public void setDrivingLicVehicleType(int drivingLicVehicleType) {
		this.drivingLicVehicleType = drivingLicVehicleType;
	}

	public String getDrivingLicValidUptoDt() {
		return drivingLicValidUptoDt;
	}

	public void setDrivingLicValidUptoDt(String drivingLicValidUptoDt) {
		this.drivingLicValidUptoDt = drivingLicValidUptoDt;
	}

	public State getDrivingLicIssuerState() {
		return drivingLicIssuerState;
	}

	public void setDrivingLicIssuerState(State drivingLicIssuerState) {
		this.drivingLicIssuerState = drivingLicIssuerState;
	}

	public Boolean getIsOwnGovVehicle() {
		return isOwnGovVehicle;
	}

	public void setIsOwnGovVehicle(Boolean isOwnGovVehicle) {
		this.isOwnGovVehicle = isOwnGovVehicle;
	}

	public String getGovVehicleDetails() {
		return govVehicleDetails;
	}

	public void setGovVehicleDetails(String govVehicleDetails) {
		this.govVehicleDetails = govVehicleDetails;
	}

	public Boolean getIsResidentOfOtherCountry() {
		return isResidentOfOtherCountry;
	}

	public void setIsResidentOfOtherCountry(Boolean isResidentOfOtherCountry) {
		this.isResidentOfOtherCountry = isResidentOfOtherCountry;
	}

	public String getMigDtOfIndia() {
		return migDtOfIndia;
	}

	public void setMigDtOfIndia(String migDtOfIndia) {
		this.migDtOfIndia = migDtOfIndia;
	}

	public Nation getResidentOf() {
		return residentOf;
	}

	public void setResidentOf(Nation residentOf) {
		this.residentOf = residentOf;
	}

	public String getOtherCountryAddress() {
		return otherCountryAddress;
	}

	public void setOtherCountryAddress(String otherCountryAddress) {
		this.otherCountryAddress = otherCountryAddress;
	}

	public Boolean getIsAnyDiciplinaryProceeding() {
		return isAnyDiciplinaryProceeding;
	}

	public void setIsAnyDiciplinaryProceeding(Boolean isAnyDiciplinaryProceeding) {
		this.isAnyDiciplinaryProceeding = isAnyDiciplinaryProceeding;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Boolean getIsGovVehicleUsedForOnDuty() {
		return isGovVehicleUsedForOnDuty;
	}

	public void setIsGovVehicleUsedForOnDuty(Boolean isGovVehicleUsedForOnDuty) {
		this.isGovVehicleUsedForOnDuty = isGovVehicleUsedForOnDuty;
	}
}
