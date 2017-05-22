package com.HavanaClub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HavanaClub.entity.MeasuringSystem;
import com.HavanaClub.service.MeasuringSystemService;

@Controller
public class MeasuringSystemController {
	
	@Autowired
	private MeasuringSystemService measuringSystemService;
	
	@GetMapping("/measuringSystem")
	public String measuringSystem(Model model){
		model.addAttribute("measuringSystems", measuringSystemService.findAll());
		return "measuringSystem";
	}
	
	@PostMapping("/measuringSystem")
	public String measuringSystem(@RequestParam String name){
		
		measuringSystemService.save(new MeasuringSystem(name));
		
		return "redirect:/measuringSystem";
	}
	
	@GetMapping("/deleteMeasuringSystem/{id}")
	public String deleteMeasuringSystem(@PathVariable int id){
		measuringSystemService.delete(id);
		
		return "redirect:/measuringSystem";
	}
	
	@GetMapping("/updateMeasuringSystem/{id}")
	public String updateMeasuringSystem(@PathVariable int id, Model model){
		
		MeasuringSystem measuringSystem = measuringSystemService.findOne(id);
		
		model.addAttribute("currentMeasuringSystem", measuringSystem);
		
		return "updateMeasuringSystem";
		
	}
	
	@PostMapping("/updateMeasuringSystem/{id}")
	public String updateMeasuringSystem(@RequestParam String name, @PathVariable int id){
		
		MeasuringSystem measuringSystem = measuringSystemService.findOne(id);
		
		measuringSystem.setName(name);
		
		measuringSystemService.update(measuringSystem);
		
		return "redirect:/measuringSystem";
	}
	
}
