package com.HavanaClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.service.IngredientService;

@Controller
public class IngredientController {
	
	@Autowired
	private IngredientService ingredientService;

	@GetMapping("/ingredient")
	public String ingredient(Model model){
		model.addAttribute("ingredients", ingredientService.findAll());
		model.addAttribute("ingredient", new Ingredient());
		return "ingredient";
	}
	@PostMapping("/ingredient")
	public String ingredient(@ModelAttribute Ingredient ingredient){
		
		ingredientService.save(ingredient);

		return "redirect:/ingredient";
	}
	
	@GetMapping("/deleteIngredient/{id}")
	public String deleteIngredient(@PathVariable int id){
		
		ingredientService.delete(id);
		
		return "redirect:/ingredient";
		
	}
	
	@GetMapping("/updateIngredient/{id}")
	public String updateIngredient(@PathVariable int id, Model model){
		
		Ingredient ingredient = 
				ingredientService.findOne(id);
		
		model.addAttribute("ingredient", ingredient);
		
		return "updateIngredient";
		
	}
	
	
}
