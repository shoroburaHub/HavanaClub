package com.HavanaClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/signUp")
	public String signUp(){
		return "signUp";
	}

	@PostMapping("/signUp")
	public String signUp(@RequestParam String name,
								@RequestParam String email,
								@RequestParam String password){
		
		userService.save(new User(name, email, password));
		
		return "redirect:/";
	}
	
}
