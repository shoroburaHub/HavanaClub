package com.HavanaClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.HavanaClub.service.UserService;

@Controller
public class ProfileController {

	@Autowired
	private UserService userService; 
	
	@GetMapping("/profile/{id}")
	public String profile(@PathVariable int id, Model model){
		
		model.addAttribute("currentUser", userService.findUserWithOrders(id));
		
		return "profile";
	}
	
	
}
