package com.hrms.system.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.system.models.Address;
import com.hrms.system.models.BankBranch;
import com.hrms.system.models.City;
import com.hrms.system.models.District;
import com.hrms.system.models.State;
import com.hrms.system.services.AddressService;
import com.hrms.system.services.BankBranchService;
import com.hrms.system.services.CityService;
import com.hrms.system.services.DistrictService;
import com.hrms.system.services.StateService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private BankBranchService branchService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/getBankBranches/{bank_id}")
	public ResponseEntity<List<BankBranch>> getAreaList(@PathVariable Long bank_id) {
		return new ResponseEntity<>(branchService.getBankBranchs(bank_id), HttpStatus.OK);
	}
	
	@GetMapping("/getIFSCCode/{branch_id}")
	public ResponseEntity<String> getIFSCCode(@PathVariable Long branch_id) {
		return new ResponseEntity<>(branchService.getIFSCCode(branch_id), HttpStatus.OK);
	}
	
	@PostMapping("/addAddress")
	public ResponseEntity<Address> addAddress(@ModelAttribute Address address) {
		return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.OK);
//		return new ResponseEntity<>(address , HttpStatus.OK);
	}
	
	@GetMapping("/getStates/{country_id}")
	public ResponseEntity<List<State>> getStates(@PathVariable Long country_id) {
		return new ResponseEntity<>(stateService.getStates(country_id), HttpStatus.OK);
	}
	
	@GetMapping("/getDistricts/{state_id}")
	public ResponseEntity<List<District>> getDistricts(@PathVariable Long state_id) {
		return new ResponseEntity<>(districtService.getDistricts(state_id), HttpStatus.OK);
	}
	
	@GetMapping("/getCities/{district_id}")
	public ResponseEntity<List<City>> getCities(@PathVariable Long district_id) {
		return new ResponseEntity<>(cityService.getCities(district_id), HttpStatus.OK);
	}
	
	@GetMapping("/deleteAddress/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable Long id) {
		return new ResponseEntity<>(addressService.deleteAddress(id), HttpStatus.OK);
	}
}
