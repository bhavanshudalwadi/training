package com.hrms.system.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrms.system.services.DepartmentService;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
	@Autowired
	private DepartmentService service;
}
