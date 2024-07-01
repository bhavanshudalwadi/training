package com.hrms.system.controllers;

import java.security.Principal;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrms.system.models.Contact;
import com.hrms.system.models.Designation;
import com.hrms.system.models.Employee;
import com.hrms.system.models.PersonalInfo;
import com.hrms.system.services.AddressService;
import com.hrms.system.services.BankService;
import com.hrms.system.services.ContactService;
import com.hrms.system.services.DepartmentService;
import com.hrms.system.services.DesignationService;
import com.hrms.system.services.EmployeeService;
import com.hrms.system.services.GroupService;
import com.hrms.system.services.NationService;
import com.hrms.system.services.PersonalInfoService;
import com.hrms.system.services.StateService;
import com.hrms.system.services.UnitService;
import com.hrms.system.services.UserService;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private PersonalInfoService personalInfoService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private DesignationService designationService;
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private UnitService unitService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private NationService nationService;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/addEmployee")
	public String addEmployee(Model model, Principal p) {
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("departments", departmentService.getDepartments());
		model.addAttribute("designations", designationService.getDesignations());
		model.addAttribute("units", unitService.getUnits());
		model.addAttribute("groups", groupService.getGroups());
		model.addAttribute("codePrefix", "STTL");
		Random r = new Random();
		model.addAttribute("codeValue", r.nextInt(999999));
		return "employee-add";
	}
	
	@PostMapping("/addHandler")
	public String addEmployeeHandler(
		RedirectAttributes redirectAttributes,
		@ModelAttribute Employee employee,
		@RequestParam("codePrefix") String codePrefix,
		@RequestParam("codeValue") String codeValue
	) {
		employee.setCode(codePrefix + "/" + codeValue);
		Employee emp = service.addEmployee(employee);
		return "redirect:/emp/addPersonalInfo/"+emp.getId();
	}
	
	@GetMapping("/addPersonalInfo/{id}")
	public String addPersonalInfo(Model model, Principal p, @PathVariable Long id) {
		model.addAttribute("emp", service.getEmployee(id));
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("banks", bankService.getBanks());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("nations", nationService.getNations());
		return "personal-info-add";
	}
	
	@GetMapping("/editPersonalInfo/{id}")
	public String editPersonalInfo(Model model, Principal p, @PathVariable Long id) {
		PersonalInfo pi = personalInfoService.getPersonalInfo(id);
		model.addAttribute("personalInfo", pi);
		model.addAttribute("emp", service.getEmployee(id));
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("banks", bankService.getBanks());
		model.addAttribute("states", stateService.getStates());
		model.addAttribute("nations", nationService.getNations());
		return "personal-info-add";
	}
	
	@PostMapping("/addPersonalInfoHandler")
	public String addPersonalInfoHandler(
		RedirectAttributes redirectAttributes,
		@ModelAttribute PersonalInfo personalInfo
	) {
		PersonalInfo pf = personalInfoService.addPersonalInfo(personalInfo);
		return "redirect:/emp/addContactDetails/"+pf.getEmp().getId();
	}
	
	@GetMapping("/addContactDetails/{id}")
	public String addContactInfo(Model model, Principal p, @PathVariable Long id) {
		model.addAttribute("emp", service.getEmployee(id));
		model.addAttribute("addresses", addressService.getAddresses(id));
		model.addAttribute("countries", nationService.getNations());
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		return "contact-add";
	}
	
	@PostMapping("/addContactDetailsHandler")
	public String addContactDetailsHandler(
		RedirectAttributes redirectAttributes,
		@ModelAttribute Contact contact
	) {
		Contact c = contactService.addContactDetails(contact);
		return "redirect:/emp/addFamilyDetails/"+c.getEmp().getId();
	}
	
	@GetMapping("/addFamilyDetails/{id}")
	public String addFamilyDetails(Model model, Principal p, @PathVariable Long id) {
		model.addAttribute("emp", service.getEmployee(id));
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		return "family-add";
	}
}
