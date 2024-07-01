package com.food.order.controllers;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.food.order.models.Offer;
import com.food.order.services.CategoryService;
import com.food.order.services.OfferService;
import com.food.order.services.UserService;

@Controller
@RequestMapping("/offer")
public class OfferController {
	@Autowired
	private OfferService service;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("deprecation")
	@GetMapping("/list")
	public String offerList(Model model, Principal p) {
		List<Offer> list = service.getOffers(p.getName());
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dp = new SimpleDateFormat("yyyy-MM-dd");  
		list.forEach(l -> {
			try {
				l.setStartDate(df.format(dp.parse(l.getStartDate())));
				l.setEndDate(df.format(dp.parse(l.getEndDate())));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		});
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("offers", list);
		return "offer-list";
	}
	
	@GetMapping("/add")
	public String addOffer(Model model, Principal p) {
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("user_id", userService.getUserByEmail(p.getName()).getId());
		return "offer-add";
	}
	
	@PostMapping("/addHandler")
	public String addOfferHandler(@ModelAttribute Offer offer) {		

		service.addOffer(offer);
		return "redirect:/offer/list";
	}
	
	@GetMapping("/edit/{id}")
	public String editOffer(@PathVariable Long id, Model model, Principal p) {
		Offer oldInfo = service.getOffer(id);
		model.addAttribute("user_id", userService.getUserByEmail(p.getName()).getId());
		model.addAttribute("userRole", userService.getUserRole(p.getName()));
		model.addAttribute("categories", categoryService.getCategories());
		model.addAttribute("offer", oldInfo);
		return "offer-add";
	}
	
	@PostMapping("/updateHandler")
	public String updateOfferHandler(@ModelAttribute Offer offer) {
		service.updateOffer(offer);
		return "redirect:/offer/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteOffer(@PathVariable Long id) {
		service.deleteOffer(id);
		return "redirect:/offer/list";
	}
}
