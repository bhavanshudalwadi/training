package com.session.management.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		List<String> messages = (List<String>) session.getAttribute("My_Session");
		if (messages == null) {
			messages = new ArrayList<String>();
		}
		model.addAttribute("sessionMessages", messages);
		return "index";
	}
	
	@PostMapping("/addSession")
	public String storeSession(HttpServletRequest request) {
		List<String> messages = (List<String>) request.getSession().getAttribute("My_Session");
		if (messages == null) {
			messages = new ArrayList<String>();
			request.getSession().setAttribute("My_Session", messages);
		}
		messages.add(request.getParameter("msg"));
		request.getSession().setAttribute("My_Session", messages);
		return "redirect:/";
	}
}
