package com.HavanaClub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HavanaClub.entity.Country;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.service.CountryService;
import com.HavanaClub.service.DrinkService;
import com.HavanaClub.service.IngredientService;

@Controller
public class DrinkController {

	@Autowired
	private DrinkService drinkService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private IngredientService ingredientService;
	
	private Country country = null;
	
	@GetMapping("/drink")
	public String drink(Model model){
		
		model.addAttribute("drinks", drinkService.drinksWithIngredients());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("ingredients", ingredientService.findAll());
		
		if(country == null){			
			country = countryService.findAll().get(0);
		}
		
		
		model.addAttribute("country", country);
		
		return "drink";
	}
	
	@PostMapping("/drink")
	public String drink(@RequestParam String name, 
			@RequestParam List<Integer> ingredientIds,
			@RequestParam int countryId,
			Model model){
		
		country = countryService.findOne(countryId);
		
		drinkService.save(new Drink(name), ingredientIds , countryId);
		
		return "redirect:/drink";
	}
	
	@GetMapping("/deleteDrink/{id}")
	public String deleteDrink(@PathVariable int id){
		
		drinkService.delete(id);
		
		return "redirect:/drink";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
