package com.HavanaClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.service.IngredientService;
import com.HavanaClub.service.MeasuringSystemService;

@Controller
public class IngredinetController {
	
	@Autowired
	private IngredientService ingredientService;
	@Autowired
	private MeasuringSystemService measuringSystemService; 
	
	@GetMapping("/ingredient")
	public String ingredient(Model model){
		model.addAttribute("ingredients", ingredientService.ingredientsWithMeasuringSystem());
		model.addAttribute("measuringSystems", measuringSystemService.findAll());
		return "ingredient";
	}
	@PostMapping("/ingredient")
	public String ingredinet(@RequestParam String name,
							@RequestParam double quantity,
							@RequestParam int ms){
		
		ingredientService.save(new Ingredient(name, quantity), ms);
		
		
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
				ingredientService.findIngredientWithMeasuringSystem(id);
		
		model.addAttribute("ingredient", ingredient);
		
		return "updateIngredient";
		
	}
	
	
}
