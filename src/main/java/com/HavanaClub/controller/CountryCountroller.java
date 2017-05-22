package com.HavanaClub.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.HavanaClub.entity.Country;
import com.HavanaClub.service.CountryService;

@Controller
public class CountryCountroller {

	@Autowired
	private CountryService countryService;
	
	@GetMapping("/country")
	public String country(Model model){
		model.addAttribute("countries", countryService.findAll());
		return "country";
	}
	
//	@GetMapping("/country")
//	public ModelAndView country( ){
//		
//		Map<String, List<Country>> map = 
//				new HashMap<String, List<Country>>();
//		
//		map.put("countries", countryService.findAll());
//		
//		return new ModelAndView("country", map) ;
//	}
	
	@PostMapping("/country")
	public String country(@RequestParam String countryName){
		countryService.save(new Country(countryName));
		return "redirect:/country";
	}
	
	@GetMapping("/deleteCountry/{id}")
	public String delete(@PathVariable int id){
		
		countryService.delete(id);
		
		return "redirect:/country";
	}
	
	
	
	
	
	
}
