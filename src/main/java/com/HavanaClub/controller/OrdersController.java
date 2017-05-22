package com.HavanaClub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HavanaClub.service.OrdersService;

@Controller
public class OrdersController {
	
	@Autowired 
	private OrdersService ordersService;

	@PostMapping("/createNewOrder")
	public String createNewOrder(@RequestParam int userId,
								@RequestParam List<Integer> drinkIds){
		
		ordersService.save(userId, drinkIds);
		
		
		return "redirect:/";
	}
	
}
