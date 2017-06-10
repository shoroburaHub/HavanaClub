package com.HavanaClub.controller;

import java.security.Principal;

import com.HavanaClub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.HavanaClub.service.OrdersService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrdersController {
	
	@Autowired 
	private OrdersService ordersService;

	@Autowired
	private UserService userService;

	@GetMapping("/addIntoBasket/{id}")
	public String buy(Principal principal, @PathVariable int id, Model model){

		ordersService.addIntoBasket(principal, id);

		return "redirect:/";
	}

	@GetMapping("/deleteFromBasket/{userId}/{drinkId}")
	public String deleteFromBasket(@PathVariable int userId,
								   @PathVariable int drinkId){

		ordersService.deleteFromBasket(userId, drinkId);

		return "redirect:/profile";
	}

	@PostMapping("/buy")
	public String buy(Principal principal){

		ordersService.buy(Integer.parseInt(principal.getName()));

		return "redirect:/profile";

	}
	
}
